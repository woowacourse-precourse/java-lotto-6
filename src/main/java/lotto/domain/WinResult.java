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

    public void changeWinResult(int value) {

    }
    private void increaseWinResultValue(int value) {
        winResult.put(value, winResult.get(value) + Number.PLUS_ONE.getValue());
    }

    private boolean isOverTwo(int sameNumberCount) {
        return true;
    }

    private boolean isFiveSame(int sameNumberCount) {
        return true;
    }
}
