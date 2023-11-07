package lotto;

import java.util.List;

public class LottoMachine {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoCalculator lottoCalculator = new LottoCalculator();

    public List<Lotto> createLottos(int lottoCount) {
        return lottoGenerator.createLottos(lottoCount);
    }

    public void setWinningNumberToCalculator(WinningNumber winningNumber) {
        lottoCalculator.setWinningNumber(winningNumber);
    }

    public List<Rank> calculateRank(List<Lotto> createdLotto) {
        return lottoCalculator.getLottoRanks(createdLotto);
    }

    public double calculateRate(Money money, List<Rank> ranks) {
        double prizeSum = 0;
        double cost = (double) money.getAmount();

        for (Rank rank : ranks) {
            prizeSum += (double) rank.getPrize();
        }

        return prizeSum / cost * 100;
    }
}
