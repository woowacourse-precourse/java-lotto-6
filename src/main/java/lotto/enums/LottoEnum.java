package lotto.enums;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

import static lotto.LottoConst.LOTTO_COUNT;
import static lotto.LottoConst.LOTTO_PRICE;

public enum LottoEnum {

    W1(LOTTO_COUNT, 0,2000000000),
    W2(LOTTO_COUNT-1, 1,30000000),
    W3(LOTTO_COUNT-1, 0,1500000),
    W4(LOTTO_COUNT-2, 0,50000),
    W5(LOTTO_COUNT-3, 0,5000);


    private final int winCount;
    private final int bonusCount;
    private final int reward;


    LottoEnum(int winCount, int bonusCount, int reward) {
        this.winCount = winCount;
        this.bonusCount = bonusCount;
        this.reward = reward;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getReward() {
        return reward;
    }

    public static LottoEnum getLottoEnum(int count, int bonusCount) {
        LottoEnum[] values = LottoEnum.values();
        for (LottoEnum value : values) {
            if (value.winCount == count && value.bonusCount == bonusCount) {
                return value;
            }
        }
        return null;
    }



}
