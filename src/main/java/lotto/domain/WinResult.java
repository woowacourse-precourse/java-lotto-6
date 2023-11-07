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
        winResult.put(THREE.getRankKey(), winResultInit);
        winResult.put(FOUR.getRankKey(), winResultInit);
        winResult.put(FIVE_WITHOUT_BOUNUS.getRankKey(), winResultInit);
        winResult.put(FIVE_WITH_BONUS.getRankKey(), winResultInit);
        winResult.put(SIX.getRankKey(), winResultInit);
    }

    public Integer getWinResultValue(int rankKey) {
        return winResult.get(rankKey);
    }

    public void increaseWinResultValue(int rankKey) {
        winResult.put(rankKey, winResult.get(rankKey) + incrementWinResult);
    }

    public boolean isOverTwo(int sameNumberNum) {
        return sameNumberNum > LOTTO_SAME_NUMBER_TWO.getValue();
    }

    public boolean isFiveSame(int sameNumberNum) {
        return sameNumberNum == LOTTO_SAME_NUMBER_FIVE.getValue();
    }
}
