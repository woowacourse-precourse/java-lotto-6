package lotto.model;

import java.util.*;
import java.util.stream.Stream;

public class WinningManager {
    private List<Integer> mainNumbers;
    private Integer bonusNumber;

    private HashMap<WinningRank, Integer> winningStats;

    public WinningManager(List<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
        winningStats = new HashMap<WinningRank, Integer>();
    }

    public WinningStats matchAll(ArrayList<Lotto> lottoBundle) {

        for (WinningRank winningRank : WinningRank.values()) {
            long count = lottoBundle.stream()
                    .map(lotto -> lotto.match(mainNumbers, bonusNumber))
                    .filter(r -> r.equals(winningRank)).count();
            winningStats.put(winningRank, (int) count);
        }
        return new WinningStats(winningStats);
    }


}
