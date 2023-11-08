package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningNumber;

public class StatisticsController {
    private final Lottos lottos;
    private final WinningNumber winningNumber;

    private Map<Rank, Integer> rankTable = new LinkedHashMap<>();

    public StatisticsController(Lottos lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public void process() {
        initStatistics();
        matchAllLottos();
    }

    public void initStatistics() {
        rankTable.put(Rank.FIFTH, 0);  // 3개 일치
        rankTable.put(Rank.FOURTH, 0); // 4개 일치
        rankTable.put(Rank.THIRD, 0); // 5개 일치
        rankTable.put(Rank.SECOND, 0); // 5개 + 1개 일치
        rankTable.put(Rank.FIRST, 0); // 6개 일치
    }

    public void matchAllLottos() {
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        boolean containBonusNumber;
        ArrayList<Lotto> lottos = this.lottos.getLottos();
        for (Lotto lotto : lottos) {
            int count = (int) lotto.getLottoNumbers().stream().filter(winningNumbers::contains).count();
            containBonusNumber = lotto.getLottoNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(count, containBonusNumber);
            updateRankTable(rank);
        }
    }

    public void updateRankTable(Rank rank) {
        if (rank != Rank.MISS) {
            rankTable.replace(rank, rankTable.get(rank) + 1);
        }
    }


}
