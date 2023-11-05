package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Statistics {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000),
    NON(0,0);

    private static final int STANDARD_BONUS_COUNT = 4;
    private int count;
    private int amount;

    Statistics(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public static Statistics getStatistics(int matchCount,int bonusNumber, List<Integer> lottoNumbers) {
        if (isBonusNumber(matchCount, bonusNumber, lottoNumbers)) {
            return FIVE_BONUS;
        }
        return Arrays.stream(Statistics.values())
                .filter(data -> data.count == matchCount).findAny().orElse(NON);
    }

    private static boolean isBonusNumber(int matchCount, int bonusNumber, List<Integer> winningLotto) {
        return matchCount == STANDARD_BONUS_COUNT && winningLotto.contains(bonusNumber);
    }
}
