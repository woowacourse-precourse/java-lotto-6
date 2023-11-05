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
        winResult.put(WinnerRank.THREE.ordinal(), Number.WIN_RESULT_INIT.getValue());
        winResult.put(WinnerRank.FOUR.ordinal(), Number.WIN_RESULT_INIT.getValue());
        winResult.put(WinnerRank.FIVE_WITHOUT_BOUNUS.ordinal(), Number.WIN_RESULT_INIT.getValue());
        winResult.put(WinnerRank.FIVE_WITH_BONUS.ordinal(), Number.WIN_RESULT_INIT.getValue());
        winResult.put(WinnerRank.SIX.ordinal(), Number.WIN_RESULT_INIT.getValue());
    }

    public void increaseWinResultValue(int rankValue) {
        winResult.put(rankValue, winResult.get(rankValue) + Number.PLUS_ONE.getValue());
    }

    public boolean isOverTwo(int rankValue) {
        return rankValue >= 2;
    }

    public boolean isFiveSame(int rankValue) {
        return true;
    }
}
