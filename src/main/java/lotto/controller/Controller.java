package lotto.controller;

import java.util.List;
import lotto.controller.dto.PurchasedLottoResponse;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;
import lotto.util.RandomNumbersGenerator;
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
        outputView.printMoneyRequestMessage();
        Money money = getMoney();
        Lottos lottos = getLottos(money.getMoney());
        showPurchasedLottos(lottos);
        WinningNumbers winningNumbers = getWinningNumbers();
        showWinningStatistics(lottos, winningNumbers);
        showTotalProfit(lottos, winningNumbers, money.getMoney());
    }

    private void showPurchasedLottos(final Lottos lottos) {
        PurchasedLottoResponse purchasedLottoResponse = PurchasedLottoResponse.from(lottos.getLottos());
        outputView.printPurchasedLottos(purchasedLottoResponse.getLottos());
    }

    private Money getMoney() {
        try {
            String money = inputView.readLine();
            return Money.createWith(money);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getMoney();
        }
    }

    private Lottos getLottos(final long money) {
        return Lottos.createWith(money, new RandomNumbersGenerator());
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


    private void showWinningStatistics(final Lottos lottos, final WinningNumbers winningNumbers) {
        List<Integer> winningNumber = winningNumbers.getWinningNumber();
        int bonusNumber = winningNumbers.getBonusNumber();
        outputView.printWinningStatistics(lottos.countFirstPrizeWinners(winningNumber),
                lottos.countSecondPrizeWinners(winningNumber, bonusNumber),
                lottos.countThirdPrizeWinners(winningNumber),
                lottos.countFourthPrizeWinners(winningNumber),
                lottos.countFifthPrizeWinners(winningNumber));
    }

    private void showTotalProfit(final Lottos lottos, final WinningNumbers winningNumbers, final long money) {
        long totalPrize = lottos.calculateWinningTotalPrize(winningNumbers.getWinningNumber(),
                winningNumbers.getBonusNumber());
        outputView.printTotalProfit(totalPrize, money);
    }
}
