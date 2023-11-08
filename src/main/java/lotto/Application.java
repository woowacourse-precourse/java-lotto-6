package lotto;

import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = runPurchaseMoneyStep();
        int lottoQuantity = purchaseMoney.calculateLottoQuantity();
        LottoProcess lottoProcess = new LottoProcess();
        List<Lotto> lottos = lottoProcess.buyLotto(lottoQuantity);
        Lotto winningNumbers = runWinningNumbersStep();
        WinningLotto winningLotto = runWinningLottoStep(winningNumbers);
        List<Rank> ranks = lottoProcess.makeRanks(lottos, winningLotto);
        LottoResult lottoResult = new LottoResult();
        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());

        OutputView.printLottoQuantity(lottoQuantity);
        OutputView.printLottos(lottos);
        OutputView.printStatistics(lottoResult.getFinalResult(ranks));
        OutputView.printEarningRate(earningRate);
    }

    private static PurchaseMoney runPurchaseMoneyStep() {
        try {
            return makePurchaseMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runPurchaseMoneyStep();
    }

    private static PurchaseMoney makePurchaseMoney() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }

    private static Lotto runWinningNumbersStep() {
        try {
            return makeWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runWinningNumbersStep();
    }

    private static Lotto makeWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        return new Lotto(Converter.convertWinningNumber(winningNumbers));
    }

    private static WinningLotto runWinningLottoStep(Lotto winningNumbers) {
        try {
            return makeWinningLotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runWinningLottoStep(winningNumbers);
    }

    private static WinningLotto makeWinningLotto(Lotto winningNumbers) {
        return new WinningLotto(winningNumbers, makeBonusNumber());
    }

    private static int makeBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return Converter.convertToNumeric(bonusNumber);
    }
}