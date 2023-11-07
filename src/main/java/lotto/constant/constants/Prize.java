package lotto.constant.constants;

import java.util.List;

public enum Prize {
    // prizeCode,prize
    THREE_MATCHED(List.of(3, 5000)),
    FOUR_MATCHED(List.of(4, 50000)),
    FIVE_MATCHED(List.of(5, 1500000)),
    FIVE_AND_BONUS_MATCHED(List.of(5, 30000000)),
    SIX_MATCHED(List.of(6, 2000000000));

    private final List<Integer> result;

    Prize(List<Integer> result) {
        this.result = result;
    }


    public Integer getMatched() {
        return this.result.get(0);
    }

    public Integer getPrize() {
        return this.result.get(1);
    }
}