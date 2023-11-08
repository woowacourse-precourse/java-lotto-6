package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public PrizeStatistics calculatePrizeStatistics(WinningLotto winningLotto) {
        PrizeStatistics prizeStatistics = new PrizeStatistics();

        for (Lotto lotto : lottos) {
            Prize prize = determinePrize(lotto, winningLotto);
            prizeStatistics.updatePrizeStatistics(prize);
        }

        return prizeStatistics;
    }

    private Prize determinePrize(Lotto lotto, WinningLotto winningLotto) {
        int count = lotto.countMatchingNumbers(winningLotto.getWinningLottoNumbers());
        boolean isBonusMatched = lotto.containNumber(winningLotto.getBonusNumber());

        return Prize.getPrize(count, isBonusMatched);
    }

    @Override
    public String toString() {
        StringBuilder allLottoNumbers = new StringBuilder();
        lottos.forEach(lotto ->  allLottoNumbers.append(lotto.toString()).append("\n"));
        return allLottoNumbers.toString();
    }
}
