package lotto.domain;

import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinningManager {
    public int totalReward;
    int totalCost;
    WinningLotto winningLotto;
    public Map<Prize, Integer> prizeFrequancyTable;
    public LottoWinningManager() {
        totalReward = 0;
        prizeFrequancyTable = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeFrequancyTable.put(prize, 0);
        }
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void settlePrizeResults(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Prize result = Prize.judgeRank(winningLotto.compareNumbers(lotto), winningLotto.compareBonusNumber(lotto));
            prizeFrequancyTable.put(result, prizeFrequancyTable.get(result) + 1);
            totalReward += result.getPrizeMoney();
            totalCost = lottos.size() * 1000;
        }
    }
}
