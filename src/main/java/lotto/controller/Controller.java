package lotto.controller;

import static lotto.util.Converter.convertStringToInt;

import java.util.List;
import lotto.controller.dto.PurchasedLottoResponse;
import lotto.model.BonusNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;
import lotto.util.Converter;
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
        String money = inputView.readLine();
        return new Money(convertStringToInt(money));
    }

    private Lottos getLottos(final long money) {
        return Lottos.createWith(money, new RandomNumbersGenerator());
    }

    private WinningNumbers getWinningNumbers() {
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private WinningNumber getWinningNumber() {
        outputView.printWinningNumberRequestMessage();
        String winningNumber = inputView.readLine();
        return new WinningNumber(Converter.splitWithCommaAndConvertToIntegerList(winningNumber));
    }

    private BonusNumber getBonusNumber() {
        outputView.printBonusNumberRequestMessage();
        String bonusNumber = inputView.readLine();
        return new BonusNumber(convertStringToInt(bonusNumber));
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
