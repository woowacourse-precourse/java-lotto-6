package Controller;

import Model.Prize;
import Model.PrizeResult;
import java.util.List;
import lotto.Lotto;

public class LottoCashier {
    static final int LOTTO_PRICE = 1000;

    public PrizeResult calculateLottoResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        PrizeResult prizeResult = new PrizeResult();
        for (Lotto purchasedLotto : purchasedLottos) {
            Boolean hasBonus = purchasedLotto.hasBonus(bonusNumber);
            int matchedAmount = purchasedLotto.matchedNumberAmount(winningLotto);
            prizeResult.addPrize(Prize.calculatePrize(matchedAmount, hasBonus));
        }
        return prizeResult;
    }

    public double calculateReturnRate(int lottoAmount, PrizeResult prizeResult) {
        double investmentCost = lottoAmount * LOTTO_PRICE;
        double returnRate = (double) Math.round(prizeResult.getTotalSum() / investmentCost * 10000) / 100.0;
        return returnRate;
    }
}
