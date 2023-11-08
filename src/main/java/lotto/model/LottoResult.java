package lotto.model;

import java.util.Arrays;

public enum LottoResult {
    FIFTH_PRIZE(3, false, 5000, 0),
    FOURTH_PRIZE(4, false, 50000,1),
    THIRD_PRIZE(5, false, 1500000,2),
    SECOND_PRIZE(5, true, 30000000,3),
    FIRST_PRIZE(6, false, 2000000000,4),
    NO_PRIZE(0, false, 0,-1);

    private final Integer matchedWinningNumberCount;
    private final Boolean matchedBonusNumber;
    private final Integer prizeMoney;
    private final Integer index;

    LottoResult(Integer matchedWinningNumberCount, Boolean matchedBonusNumber, Integer prizeMoney,Integer index) {
        this.matchedWinningNumberCount = matchedWinningNumberCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.prizeMoney = prizeMoney;
        this.index = index;
    }


}
