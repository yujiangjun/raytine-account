package com.yujiangjun.account.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yujiangjun.account.components.CurrentUser;
import com.yujiangjun.account.mapper.FriendShipMapper;
import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.model.FriendShip;
import com.yujiangjun.account.service.AccountService;
import com.yujiangjun.account.service.FriendShipService;
import com.yujiangjun.account.util.SpringContextUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendShipServiceImpl extends ServiceImpl<FriendShipMapper, FriendShip> implements FriendShipService{


    @Override
    public List<Account> getMyFriends() {
        Account current = CurrentUser.getUser();
        LambdaQueryWrapper<FriendShip> queryWrapper = new QueryWrapper<FriendShip>().lambda().eq(FriendShip::getMyId, current.getId());
        List<FriendShip> shipList = list(queryWrapper);
        if (CollectionUtil.isEmpty(shipList)){
            return null;
        }
        List<Integer> friendsIds = shipList.stream().map(FriendShip::getFriendId).collect(Collectors.toList());
        LambdaQueryWrapper<Account> accountLambdaQueryWrapper = new QueryWrapper<Account>().lambda().in(Account::getId, friendsIds);
        return SpringContextUtil.getBean(AccountService.class).list(accountLambdaQueryWrapper);
    }
}
