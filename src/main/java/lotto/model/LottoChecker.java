package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

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

    public String getProfitPercentage(long money) {
        double totalProfit = getTotalProfit();
        double profitPercentage = (totalProfit / (double) money) * 100;
        return String.format("%.1f", profitPercentage);
    }

    private double getTotalProfit() {
        MatchStatus[] values = MatchStatus.values();

        return IntStream.range(0, values.length)
                .filter(i -> sameNumberCount[i] > 0)
                .mapToDouble(i -> values[i].getPrice() * sameNumberCount[i])
                .sum();
    }
}
