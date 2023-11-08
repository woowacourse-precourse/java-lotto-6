package lotto.Controller;

import lotto.Domain.Lotto;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;
import java.util.List;

public class LottoController {

    public void playLotto() {

        Integer purchaseSum = InputView.inputPurchaseSum();
        LottoService lottoService = new LottoService(purchaseSum);

        List<Lotto> lottos = lottoService.getLottos();
        OutputView.printNewLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumber();
        Integer bonusNumber = InputView.inputBonusNumber(winningNumbers);

        List<Integer> matchingCount = lottoService
                .findMatcingCount(purchaseSum / 1000, bonusNumber, winningNumbers, lottos);
        OutputView.printMatchingCount(matchingCount);

        double earningRate = lottoService.findEarningRate(purchaseSum, matchingCount);
        OutputView.printEarningRate(earningRate);
    }
}
