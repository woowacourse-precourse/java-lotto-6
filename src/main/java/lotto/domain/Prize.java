package lotto.domain;

import java.util.Arrays;

public enum Prize {

    LAST_PLACE(0, false, 0),
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 200_000_000);

    private final Integer countOfSameNumbers;
    private final Boolean checkBonus;
    private final Integer reward;

    Prize(Integer countOfSameNumbers, Boolean checkBonus, Integer reward) {
        this.countOfSameNumbers = countOfSameNumbers;
        this.checkBonus = checkBonus;
        this.reward = reward;
    }

    public static Prize of(Integer countOfSameNumbers, Boolean checkBonus) {
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

    public Integer getReward() {
        return reward;
    }
}
