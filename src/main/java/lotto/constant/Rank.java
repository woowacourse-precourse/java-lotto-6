package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE("6개 일치", 6, 2000000000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 6, 30000000),
    THIRD_PLACE("5개 일치", 5, 1500000),
    FOURTH_PLACE("4개 일치", 4, 50000),
    FIFTH_PLACE("3개 일치", 3, 5000),
    NO_PLACE("", 0, 0);

    private String standard;
    private int winingCount;
    private int money;

    private static Rank getInstance(int winingCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.winingCount == winingCount)
                .findAny()
                .orElse(NO_PLACE);
    }

    public static Rank findRank(int winingCount, int bonusCount) {
        Rank rank = getInstance(winingCount);

        if(winingCount == 6 && bonusCount == 1) {
            return SECOND_PLACE;
        }

        return rank;
    }

    Rank(String standard, int winingCount, int money) {
        this.standard = standard;
        this.winingCount = winingCount;
        this.money = money;
    }

    public String getStandard() {
        return standard;
    }

    public int getMoney() {
        return money;
    }
}
