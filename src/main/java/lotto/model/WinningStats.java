package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {


    private final Map winningStats;

    private WinningStats() {
        winningStats = new HashMap<WinningRank, Integer>();
    }

    public void addStat(WinningRank grade, int count) {

    }
}
