package com.yujiangjun.account.controller;

import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.service.FriendShipService;
import com.yujiangjun.account.vo.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/friend")
@RestController
public class FriendController extends BaseController{
    private final FriendShipService friendShipService;

    public FriendController(FriendShipService friendShipService) {
        this.friendShipService = friendShipService;
    }

    @GetMapping("/getMyFriends")
    public Resp<List<Account>> getMyFriends(){
        return success(friendShipService.getMyFriends());
    }
}
