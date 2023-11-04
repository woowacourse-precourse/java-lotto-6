package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinMetric {
    NO_WIN("2개 이하 일치", 2, false, 0),
    FIFTH("3개 일치 (5,000원)", 3, false, 5000),
    FOURTH("4개 일치 (50,000원)", 4, false, 50000),
    THIRD("5개 일치 (1,500,000원)", 5, false, 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, true, 30000000),
    FIRST("6개 일치 (2,000,000,000원)", 6, false, 2000000000),
    ;

    private final String message;
    private final int winCount;
    private final boolean isBonusWin;
    private final int winMoney;
    private int count;


    LottoWinMetric(String message, int winCount, boolean isBonusWin, int winMoney) {
        this.message = message;
        this.winCount = winCount;
        this.isBonusWin = isBonusWin;
        this.winMoney = winMoney;
        this.count = 0;
    }

    public static LottoWinMetric getLottoWinMetric(int winCount, boolean isBonusWin) {
        for (LottoWinMetric value : LottoWinMetric.values()) {
            if (value.winCount == winCount && value.isBonusWin == isBonusWin) {
                return value;
            }
        }
        return NO_WIN;
    }

    public void increase() {
        this.count++;
    }

    // this method is only for test
    public void initCount() {
        this.count = 0;
    }

    public String getMessage() {
        return this.message + " - " + this.count + "개";
    }

    public static Optional<Integer> getTotalWinMoney() {
        return Arrays.stream(LottoWinMetric.values())
                .map(metric -> metric.winMoney * metric.count)
                .reduce(Integer::sum);
    }
}
