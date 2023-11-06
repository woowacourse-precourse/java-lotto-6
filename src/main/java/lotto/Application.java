package lotto;

import java.util.List;
import java.util.Map;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.util.MatchType;

public class Application {

    private static LottoController lottoController = new LottoController();

    public static void main(String[] args) {

        int purchaseAmount = lottoController.receivePurchaseAmount();
        int lottoCount = lottoController.getPurchaseCount(purchaseAmount);
        List<Lotto> lottos = lottoController.generateLottos(lottoCount);
        List<Integer> winningNumbers = lottoController.receiveWinningNumbers();
        int bonusNumber = lottoController.receiveBonusNumber(winningNumbers);
        Map<MatchType, Integer> winningStatistics =
                lottoController.getWinningStatistics(lottos, winningNumbers, bonusNumber);
        int earnings = lottoController.getEarnings(winningStatistics);
        double totalReturn = lottoController.getReturnRate(purchaseAmount, earnings);
    }
}
