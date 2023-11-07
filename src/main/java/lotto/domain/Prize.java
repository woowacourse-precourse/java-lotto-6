package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public enum Prize {
    FIRST(6, false,2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false,1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    ZERO(0, false, 0);

    private int equalNumCount;
    private boolean hasCheckBonus;
    private int winningAmount;

    Prize(int equalNumCount, boolean hasCheckBonus, int winningAmount) {
        this.equalNumCount = equalNumCount;
        this.hasCheckBonus = hasCheckBonus;
        this.winningAmount = winningAmount;
    }

    public int getEqualNumCount() {
        return equalNumCount;
    }

    public static Prize rankLotto(int matchingCount, boolean isBonusMatching) {
        if (matchingCount == 5 && isBonusMatching) {
            return SECOND;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.equalNumCount == matchingCount)
                .findAny()
                .orElse(ZERO);

    }

}
