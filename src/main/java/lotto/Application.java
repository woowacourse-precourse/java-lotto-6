package lotto;

import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = runPurchaseMoneyStep();
        int lottoQuantity = purchaseMoney.getLottoQuantity();
        LottoProcess lottoProcess = new LottoProcess();
        List<Lotto> lottos = lottoProcess.buyLotto(lottoQuantity);
        Lotto winningNumbers = runWinningNumbersStep();
        WinningLotto winningLotto = runWinningLottoStep(winningNumbers);
        LottoResult lottoResult = lottoProcess.run(lottos, winningLotto);
        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());

        OutputView.printLottoQuantity(lottoQuantity);
        OutputView.printLottos(lottos);
        OutputView.printStatistics(lottoResult.getFinalResult());
        OutputView.printEarningRate(earningRate);
    }

    private static PurchaseMoney runPurchaseMoneyStep() {
        try {
            return setUpPurchaseMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runPurchaseMoneyStep();
    }

    private static PurchaseMoney setUpPurchaseMoney() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }

    private static Lotto runWinningNumbersStep() {
        try {
            return setUpWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runWinningNumbersStep();
    }

    private static Lotto setUpWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        return new Lotto(Converter.convertWinningNumber(winningNumbers));
    }

    private static WinningLotto runWinningLottoStep(Lotto winningNumber) {
        try {
            return setUpWinningLotto(winningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runWinningLottoStep(winningNumber);
    }

    private static WinningLotto setUpWinningLotto(Lotto winningNumbers) {
        return new WinningLotto(winningNumbers, setUpBonusNumber());
    }

    private static int setUpBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return Converter.convertToNumeric(bonusNumber);
    }
}