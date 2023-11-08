package lotto.constant;

import java.util.Arrays;

public enum Rank {
    NO_PLACE("", 0, 0),
    FIFTH_PLACE("3개 일치", 3, 5000),
    FOURTH_PLACE("4개 일치", 4, 50000),
    THIRD_PLACE("5개 일치", 5, 1500000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 6, 30000000),
    FIRST_PLACE("6개 일치", 6, 2000000000);

    private String standard;
    private int totalCount;
    private int money;

    private static Rank getInstance(int totalCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.totalCount == totalCount)
                .findAny()
                .orElse(NO_PLACE);
    }

    public static Rank findRank(int totalCount, int bonusCount) {
        Rank rank = getInstance(totalCount);

        if(totalCount == 6){
            if (bonusCount == 1){
                return SECOND_PLACE;
            }
            return FIRST_PLACE;
        }

        return rank;
    }

    Rank(String standard, int totalCount, int money) {
        this.standard = standard;
        this.totalCount = totalCount;
        this.money = money;
    }

    public String getStandard() {
        return standard;
    }

    public int getMoney() {
        return money;
    }
}
