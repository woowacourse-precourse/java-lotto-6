package lotto.domain;

import lotto.util.LottoNumber;

import java.util.HashMap;
import java.util.Map;

import static lotto.util.LottoNumber.LOTTO_SAME_NUMBER_FIVE;
import static lotto.util.LottoNumber.LOTTO_SAME_NUMBER_TWO;
import static lotto.util.WinnerRank.*;

public class WinResult {
    private final int winResultInit = 0;
    private final int incrementWinResult = 1;

    private Map<Integer, Integer> winResult;

    public WinResult() {
        winResult = new HashMap<>();
        initWinResult();
    }

    private void initWinResult() {
        winResult.put(THREE.getValue(), winResultInit);
        winResult.put(FOUR.getValue(), winResultInit);
        winResult.put(FIVE_WITHOUT_BOUNUS.getValue(), winResultInit);
        winResult.put(FIVE_WITH_BONUS.getValue(), winResultInit);
        winResult.put(SIX.getValue(), winResultInit);
    }

    public Integer getWinResultValue(int rankValue) {
        return winResult.get(rankValue);
    }

    public void increaseWinResultValue(int rankValue) {
        winResult.put(rankValue, winResult.get(rankValue) + incrementWinResult);
    }

    public boolean isOverTwo(int rankValue) {
        return rankValue > LOTTO_SAME_NUMBER_TWO.getValue();
    }

    public boolean isFiveSame(int rankValue) {
        return rankValue == LOTTO_SAME_NUMBER_FIVE.getValue();
    }
}
