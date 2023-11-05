package lotto.domain;

import lotto.util.Number;
import lotto.util.WinnerRank;

import java.util.HashMap;
import java.util.Map;

public class WinResult {
    private Map<Integer, Integer> winResult;

    public WinResult() {
        winResult = new HashMap<>();
        initWinResult();
    }

    private void initWinResult() {
        winResult.put(WinnerRank.THREE.getValue(), 0);
        winResult.put(WinnerRank.FOUR.getValue(), 0);
        winResult.put(WinnerRank.FIVE_WITHOUT_BOUNUS.getValue(), 0);
        winResult.put(WinnerRank.FIVE_WITH_BONUS.getValue(), 0);
        winResult.put(WinnerRank.SIX.getValue(), 0);
    }

    public Integer getWinResultValue(int rankValue) {
        return winResult.get(rankValue);
    }

    public void increaseWinResultValue(int rankValue) {
        winResult.put(rankValue, winResult.get(rankValue) + Number.PLUS_ONE.getValue());
    }

    public boolean isOverTwo(int rankValue) {
        return rankValue > 2;
    }

    public boolean isFiveSame(int rankValue) {
        return rankValue == 5;
    }
}
