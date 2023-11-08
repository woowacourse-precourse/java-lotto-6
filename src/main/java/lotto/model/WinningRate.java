package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Ranking;
import lotto.constant.WinningMoney;
import lotto.controller.WinningCalculator;

public class WinningRate {
    Map<Integer, Integer> winningCount = new HashMap<>();
    long profit = 0;

    private WinningRate(List<Lotto> lottos, WinningNumbers winningNumbers) {
        winningCount.put(Ranking.FIRST.getRanking(), 0);
        winningCount.put(Ranking.SECOND.getRanking(), 0);
        winningCount.put(Ranking.THIRD.getRanking(), 0);
        winningCount.put(Ranking.FOURTH.getRanking(), 0);
        winningCount.put(Ranking.FIFTH.getRanking(), 0);
        winningCount.put(Ranking.NOT_WIN.getRanking(), 0);
        countWinning(lottos, winningNumbers.getWinningNumbers(), winningNumbers.getBonusNumber());
        calculateProfit();
    }

    public static WinningRate makeWinningRate(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return new WinningRate(lottos, winningNumbers);
    }

    public Map<Integer, Integer> getWinningCount() {
        return this.winningCount;
    }

    public long getProfit() {
        return this.profit;
    }

    // 각 등수에 몇 개의 로또가 들었는지 갯수를 세는 메서드 입니다.
    private void countWinning(List<Lotto> lottos, Lotto winningNumber, BonusNumber bonusNumber) {
        WinningCalculator winningCalculator = new WinningCalculator();
        int rank;
        for (Lotto lotto : lottos) {
            rank = winningCalculator.rankWinning(lotto.getLottoNumbers(), winningNumber.getLottoNumbers(),
                    bonusNumber.getBonusNumber());
            winningCount.put(rank, winningCount.get(rank) + 1);
        }
    }

    private void calculateProfit() {
        profit += (long) winningCount.get(Ranking.FIRST.getRanking()) * WinningMoney.LOTTO_WIN.getWinningMoney();
        profit += (long) winningCount.get(Ranking.SECOND.getRanking()) * WinningMoney.SECOND_WIN.getWinningMoney();
        profit += (long) winningCount.get(Ranking.THIRD.getRanking()) * WinningMoney.THIRD_WIN.getWinningMoney();
        profit += (long) winningCount.get(Ranking.FOURTH.getRanking()) * WinningMoney.FOURTH_WIN.getWinningMoney();
        profit += (long) winningCount.get(Ranking.FIFTH.getRanking()) * WinningMoney.FIFTH_WIN.getWinningMoney();
    }
}
