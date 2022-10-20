package com.yujiangjun.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.model.FriendShip;

import java.util.List;

public interface FriendShipService extends IService<FriendShip> {


    List<Account> getMyFriends();
}
