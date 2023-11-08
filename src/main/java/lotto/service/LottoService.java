package lotto.service;

import lotto.model.Lotto;
import lotto.model.PrizeRank;
import lotto.model.WinningLotto;
import lotto.util.LottoUtils;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Lotto> purchaseLottos(int purchaseLottos) {
        int howManyLotto = purchaseLottos / 1000;
        return LottoUtils.generateLottoPaper(howManyLotto);
    }

    public WinningLotto generateWinningLotto(List<Integer> winNumbers, int bonusNumbers) {
        Lotto winningNumber = new Lotto(winNumbers);
        return new WinningLotto(winningNumber, bonusNumbers);
    }

    public PrizeRank checkWinningRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getLotto().getNumbers().contains(number)) {
                matchCount++;
            }
        }
        boolean hasBonusNumber = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return PrizeRank.valueOf(matchCount, hasBonusNumber);
    }

    public List<PrizeRank> determinePrizeRank(List<Lotto> lottoPapers, WinningLotto winningLotto) {
        List<PrizeRank> prizeRanks = new ArrayList<>();
        for (Lotto lotto : lottoPapers) {
            prizeRanks.add(checkWinningRank(lotto, winningLotto));
        }
        return prizeRanks;
    }

    public double calculateTotalPrize(List<PrizeRank> ranks) {
        double totalPrize = 0;
        for (PrizeRank rank : ranks) {
            totalPrize += rank.getPrizeMoney();
        }
        return totalPrize;
    }

    public double calculateRateOfReturn(int purchaseAmount, double totalPrize) {
        return totalPrize / purchaseAmount * 100;
    }
}
