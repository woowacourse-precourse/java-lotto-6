package lotto.domain;

import java.util.Arrays;

public enum Prize {

    LAST_PLACE(0, false, 0.0),
    FIFTH_PLACE(3, false, 5_000.0),
    FOURTH_PLACE(4, false, 50_000.0),
    THIRD_PLACE(5, false, 1_500_000.0),
    SECOND_PLACE(5, true, 30_000_000.0),
    FIRST_PLACE(6, false, 2_000_000_000.0);

    private final Integer countOfSameNumbers;
    private final Boolean checkBonus;
    private final Double reward;

    Prize(final Integer countOfSameNumbers, final Boolean checkBonus, final Double reward) {
        this.countOfSameNumbers = countOfSameNumbers;
        this.checkBonus = checkBonus;
        this.reward = reward;
    }

    public static Prize of(final Integer countOfSameNumbers, final Boolean checkBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.countOfSameNumbers == countOfSameNumbers && prize.checkBonus == checkBonus)
                .findFirst()
                .orElse(LAST_PLACE);
    }

    public Integer getCountOfSameNumbers() {
        return countOfSameNumbers;
    }

    public Boolean getCheckBonus() {
        return checkBonus;
    }

    public Double getReward() {
        return reward;
    }
}
