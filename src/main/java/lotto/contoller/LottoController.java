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

    public void runGame() {
        outputView.printInputPurchaseMoney();
        int purchaseCount = inputService.readPurchasingAmount();
        Lottos lottos = lottoDomain.createLottos(purchaseCount);

        outputView.printPurchaseResult(lottos, purchaseCount);

        outputView.printInputWinningNumber();
        List<Integer> winningNum = inputService.readWinningNumbers();

        outputView.printInputBonusNumber();
        int bonusNumber = inputService.readBonusNumber(winningNum);
        WinningNumbers winningNumbers = lottoDomain.createWinningNumbers(winningNum, bonusNumber);

        outputView.printWinningState();

        Map<String, Integer> resultStats = lottoDomain.compareNumbers(lottos, winningNumbers);
        float earningMoney = lottoDomain.printLottoStats(resultStats, purchaseCount);

        outputView.printEarningRatio(earningMoney);
    }


}
