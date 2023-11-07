package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Compare {
    ONE(6, "6개 일치", 2000000000),
    TWO(5, "5개 일치, 보너스 볼 일치", 30000000),
    THREE(4, "5개 일치", 1500000),
    FOUR(3, "4개 일치", 50000),
    FIVE(2, "3개 일치", 5000);

    private int shot;
    private String reply;
    private int money;

    Compare(int shot, String reply, int money) {
        this.shot = shot;
        this.reply = reply;
        this.money = money;
    }

    public static Compare getRank(int shot, boolean bonusShot) {
        if()
    }
}
