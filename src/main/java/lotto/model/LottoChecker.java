package lotto.model;

import lotto.MatchStatus;

import java.util.List;

public class LottoChecker {
    private List<Lotto> lottos;
    private List<Integer> winningLotto;
    private int bonusLotto;
    private int[] sameNumberCount;

    public LottoChecker(List<Lotto> lottos, List<Integer> winningLotto, int bonusLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusLotto = bonusLotto;
        sameNumberCount = new int[5];
    }

    public void checkLottoWithWinningLotto() {
        lottos.stream()
                .forEach(lotto -> lotto.compareLottoWithWinningLotto(winningLotto, sameNumberCount, bonusLotto));
    }

    public int[] getSameNumberCount() {
        return sameNumberCount.clone();
    }

    public double getProfitPercentage(long money) {
        double totalProfit = getTotalProfit();
        double profitPercentage = (totalProfit / (double) money) * 100;
        return profitPercentage;
    }

    private double getTotalProfit() {
        MatchStatus[] values = MatchStatus.values();
        double totalProfit = 0;
        for (int i = 0; i < values.length; i++) {
            if (sameNumberCount[i] > 0) {
                totalProfit += values[i].getPrice();
            }
        }
        return totalProfit;
    }
}
