package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;

public enum LottoValue {
    THREE(3, 5000, "3개 일치 (5000원)"),
    FOUR(4, 50000, "4개 일치 (50,000원)"),
    FIVE(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int count;
    public final int winningMoney;
    public final String result;

    LottoValue(int count, int winningMoney, String result) {
        this.count = count;
        this.winningMoney = winningMoney;
        this.result = result;
    }

    public static LottoValue getLottoValue(int count) {
        for (LottoValue lottoValue : LottoValue.values()) {
            if (lottoValue.count == count) {
                return lottoValue;
            }
        }
        return null;
    }
}
