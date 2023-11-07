package model;

import java.util.Arrays;

public enum Rank {
    FIFTH(3,"개 일치"," (5,000원) - "),
    FOURTH(4,"개 일치"," (50,000원) - "),
    THIRD(5,"개 일치"," (1,500,000원) - "),
    SECOND(5,"개 일치, 보너스 볼 일치"," (30,000,000원) - "),

    FIRST(6,"개 일치"," (2,000,000,000원) - ");


    private final int countOfMatch;
    private final String message;
    private final String winningMoney;

    Rank(int countOfMatch, String message, String winningMoney) {
        this.countOfMatch = countOfMatch;
        this.message = message;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        // 맞춘 숫자 개수에 따른 등수를 반환
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findAny()
                .orElse(null);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public String getMessage() {
        return message;
    }

    public String getWinningMoney() {
        return winningMoney;
    }
}

