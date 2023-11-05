package lotto.domain;

public class UserMoney {
    private Long userMoney;
    private UserMoney(Long userMoney){
        this.userMoney = userMoney;
    }

    public static UserMoney of(String userMoney){
        return new UserMoney(Long.parseLong(userMoney));
    }
}