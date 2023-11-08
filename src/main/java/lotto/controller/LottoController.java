package lotto.controller;

import java.util.List;
import lotto.model.Cashier;
import lotto.model.Lotto;
import lotto.model.RateOfReturnCalculator;
import lotto.model.Result;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    static Cashier cashier = new Cashier();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public void start() {
        List<Lotto> lottos;
        int purchaseAmount;

        do {
            purchaseAmount = inputView.inputPurchaseAmount();
            lottos = cashier.takeOrder(purchaseAmount);
        } while (lottos == null);
        outputView.printcreatedResult(lottos);

        Lotto winningNumber;
        do {
            winningNumber = inputView.inputWinningNumber();
        } while (winningNumber == null);

        int bonusNumber;
        do {
            bonusNumber = inputView.inputBonusNumber();
        } while (winningNumber.contains(bonusNumber) || bonusNumber == -1);

        WinningNumber winningNumber1 = new WinningNumber(winningNumber, bonusNumber);
        Result result = winningNumber1.calculateLottosWinningResult(lottos);
        outputView.printWinningResult(result);

        RateOfReturnCalculator rateOfReturnCalculator = new RateOfReturnCalculator();
        double rateOfReturn = rateOfReturnCalculator.calculate(result.calculatePrizeMoney(),
                purchaseAmount);

        outputView.printRateOfReturn(rateOfReturn);
    }
}
