package lotto.domain;

import java.util.Arrays;

public enum Prize {

    LAST_PLACE(0, false, 0.0),
    FIFTH_PLACE(3, false, 5_000.0),
    FOURTH_PLACE(4, false, 50_000.0),
    THIRD_PLACE(5, false, 1_500_000.0),
    SECOND_PLACE(5, true, 30_000_000.0),
    FIRST_PLACE(6, false, 2_000_000_000.0);

    private final Integer countOfMatchedNumber;
    private final Boolean isBonusNumber;
    private final Double reward;

    Prize(final Integer countOfMatchedNumber, final Boolean isBonusNumber, final Double reward) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.isBonusNumber = isBonusNumber;
        this.reward = reward;
    }

    public static Prize of(final Integer countOfSameNumbers, final Boolean checkBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.countOfMatchedNumber == countOfSameNumbers && prize.isBonusNumber == checkBonus)
                .findFirst()
                .orElse(LAST_PLACE);
    }

    public Integer getCountOfMatchedNumber() {
        return countOfMatchedNumber;
    }

    public Boolean isBonusNumber() {
        return isBonusNumber;
    }

    public Double getReward() {
        return reward;
    }
}
