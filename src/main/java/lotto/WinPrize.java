package lotto;

import lotto.Enum.Prize;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class WinPrize {

    private Map<Prize, Integer> winPrize;

    public WinPrize(Map<Prize, Integer> winPrize) {
        ResultInit();
        this.winPrize = winPrize;
    }

    public WinPrize() {
        ResultInit();
    }

    public Map<Prize, Integer> getWinPrize() {
        return winPrize;
    }

    public void setWinPrize(Map<Prize, Integer> winPrize) {
        this.winPrize = winPrize;
    }

    private void ResultInit() {
        winPrize = new TreeMap<>(Collections.reverseOrder());
        winPrize.put(Prize.THREE_CORRECT, 0);
        winPrize.put(Prize.FOUR_CORRECT, 0);
        winPrize.put(Prize.FIVE_CORRECT_NOT_BONUS, 0);
        winPrize.put(Prize.FIVE_CORRECT_MATCH_BONUS, 0);
        winPrize.put(Prize.SIX_CORRECT, 0);
    }

}
