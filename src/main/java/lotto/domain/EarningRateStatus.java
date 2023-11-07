package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum EarningRateStatus {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    FIVE_BONUS(7, 30000000);

    private int index;
    private int value;
    private static final Map<Integer, EarningRateStatus> indexMap = new HashMap<>();

    static {
        for (EarningRateStatus win : EarningRateStatus.values()) {
            indexMap.put(win.index, win);
        }
    }

    EarningRateStatus(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public static int getValueByIndex(int index) {
        return indexMap.get(index).value;
    }
}
