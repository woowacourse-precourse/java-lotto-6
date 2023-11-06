package lotto.controller;

import java.util.Map;
import lotto.controller.dto.LottosResponse;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbersGenerator;
import lotto.model.LottoPrizeCalculator;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final OutputView outputView;
    private final InputView inputView;

    public Controller(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getMoney());
        showPurchasedLottos(lottos);
        WinningNumbers winningNumbers = getWinningNumbers();
        LottoPrizeCalculator lottoPrizeCalculator = getLottoPrizeCalculator(lottos, winningNumbers);
        showWinningStatistics(lottoPrizeCalculator);
        showTotalProfit(lottoPrizeCalculator, money.getMoney());
    }

    private void showPurchasedLottos(final Lottos lottos) {
        LottosResponse lottosResponse = LottosResponse.from(lottos.getLottos());
        outputView.printPurchasedLottos(lottosResponse.getLottos());
    }

    private Money getMoney() {
        try {
            outputView.printMoneyRequestMessage();
            String money = inputView.readLine();
            return Money.createWith(money);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getMoney();
        }
    }

    private Lottos getLottos(final long money) {
        return Lottos.createWith(money, new LottoNumbersGenerator());
    }

    private WinningNumbers getWinningNumbers() {
        try {
            WinningNumber winningNumber = getWinningNumber();
            LottoNumber bonusNumber = getBonusNumber();
            return new WinningNumbers(winningNumber, bonusNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getWinningNumbers();
        }
    }

    private WinningNumber getWinningNumber() {
        try {
            outputView.printWinningNumberRequestMessage();
            String winningNumber = inputView.readLine();
            return WinningNumber.createWith(winningNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getWinningNumber();
        }
    }

    private LottoNumber getBonusNumber() {
        try {
            outputView.printBonusNumberRequestMessage();
            String bonusNumber = inputView.readLine();
            return LottoNumber.createWith(bonusNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getBonusNumber();
        }
    }

    private LottoPrizeCalculator getLottoPrizeCalculator(final Lottos lottos, final WinningNumbers winningNumbers) {
        return new LottoPrizeCalculator(lottos, winningNumbers);
    }

    private void showWinningStatistics(final LottoPrizeCalculator lottoPrizeCalculator) {
        Map<String, Long> winningStatistics = lottoPrizeCalculator.getWinningStatistics();
        outputView.printWinningStatistics(winningStatistics);
    }

    private void showTotalProfit(final LottoPrizeCalculator lottoPrizeCalculator, final long money) {
        long totalPrize = lottoPrizeCalculator.calculateTotalPrize();
        outputView.printTotalProfit(totalPrize, money);
    }
}
