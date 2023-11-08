package lotto.model;

import java.util.*;
import java.util.stream.Stream;

public class WinningManager {
    private List<Integer> mainNumbers;
    private Integer bonusNumber;

    private final HashMap<WinningRank, Integer> winningStats;

    public WinningManager(List<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
        this.winningStats = new HashMap<WinningRank, Integer>();
    }

    public HashMap matchAll(ArrayList<Lotto> lottoBundle) {
        Stream<WinningRank> stream = lottoBundle.stream()
                .map(lotto -> lotto.match(mainNumbers, bonusNumber));

        for (WinningRank winningRank : WinningRank.values()) {
            long count = stream.filter(r -> r.equals(winningRank)).count();
            winningStats.put(winningRank, (int) count);
        }
        return winningStats;
    }


}
