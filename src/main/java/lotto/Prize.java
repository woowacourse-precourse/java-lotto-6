package lotto;

import java.lang.annotation.Inherited;

public enum Prize {
    SIX_MATCH(2000000000),
    FIVE_AND_BONUS_MATCH(30000000),
    FIVE_MATCH(1500000),
    FOUR_MATCH(50000),
    THREE_MATCH(5000),
    NO_GRADE(0),
    ;

    private final Integer price;

    Prize(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public static Integer getTotalIncome(int threeMatch, int fourMatch, int fiveMatch, int fiveAndBonusMatch, int sixMatch) {
        Integer totalIncome = 0;

        totalIncome += threeMatch * THREE_MATCH.price;
        totalIncome += fourMatch * FOUR_MATCH.price;
        totalIncome += fiveMatch * FIVE_MATCH.price;
        totalIncome += fiveAndBonusMatch * FIVE_AND_BONUS_MATCH.price;
        totalIncome += sixMatch * SIX_MATCH.price;

        return totalIncome;
    }
}
