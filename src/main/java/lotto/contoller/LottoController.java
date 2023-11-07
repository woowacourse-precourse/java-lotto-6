package lotto.contoller;

import lotto.domain.LottoDomain;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.service.InputService;
import lotto.validation.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();
    InputService inputService = new InputService(inputView, inputValidation, outputView);
    LottoDomain lottoDomain = new LottoDomain(outputView);

    Lottos lottos;
    int purchaseCount = 0;
    int bonusNumber = 0;
    WinningNumbers winningNumbers;
    double earningMoney;

    public void runGame() {
        purchaseLottos();
        inputNumbers();
        lottoResult();
    }

    private void purchaseLottos() {
        outputView.printInputPurchaseMoney();
        purchaseCount = inputService.readPurchasingAmount();
        lottos = lottoDomain.createLottos(purchaseCount);

        outputView.printPurchaseResult(lottos, purchaseCount);
    }
    private void inputNumbers() {
        outputView.printInputWinningNumber();
        List<Integer> winningNum = inputService.readWinningNumbers();

        outputView.printInputBonusNumber();
        bonusNumber = inputService.readBonusNumber(winningNum);
        winningNumbers = lottoDomain.createWinningNumbers(winningNum, bonusNumber);
    }
    private void lottoResult() {
        outputView.printWinningState();

        Map<String, Integer> resultStats = lottoDomain.compareNumbers(lottos, winningNumbers);
        earningMoney = lottoDomain.printLottoStats(resultStats, purchaseCount);

        outputView.printEarningRatio(earningMoney);
    }


}
