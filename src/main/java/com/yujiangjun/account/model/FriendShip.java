package com.yujiangjun.account.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class FriendShip implements Serializable {
    private Integer id;

    private Integer friendId;

    private Integer myId;

    private static final long serialVersionUID = 1L;
}