package lotto.service;

import java.util.HashMap;
import java.util.Map;

public enum ResultWinStatus {
    RIGHT_THREE(1, "3개 일치 (5,000원) - "),
    RIGHT_FOUR(2, "4개 일치 (50,000원) - "),
    RIGHT_FIVE(3, "5개 일치 (1,500,000원) - "),
    RIGHT_FIVE_BONUS(4, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RIGHT_SIX(5, "6개 일치 (2,000,000,000원) - ");

    private int index;
    private String message;

    private static final Map<Integer, ResultWinStatus> indexMap = new HashMap<>();

    static {
        for (ResultWinStatus win : ResultWinStatus.values()) {
            indexMap.put(win.index, win);
        }
    }

    ResultWinStatus(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getIndexMessage(int index) {
        return indexMap.get(index).message;
    }
}
