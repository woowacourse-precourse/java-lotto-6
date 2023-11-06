package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.service.ResultWinEnum;

public enum EarningRateNum {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(10, 30000000),
    SIX(6, 2000000000);

    private int index;
    private int value;
    private static final Map<Integer, EarningRateNum> indexMap = new HashMap<>();

    static {
        for (EarningRateNum win : EarningRateNum.values()) {
            indexMap.put(win.index, win);
        }
    }

    EarningRateNum(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public static int getValueByIndex(int index) {
        return indexMap.get(index).value;
    }
}
