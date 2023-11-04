package lotto.controller;

import static lotto.util.Converter.convertStringToInt;

import java.util.List;
import lotto.controller.dto.PurchasedLottoResponse;
import lotto.model.BonusNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumber;
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
        showPurchasedLotto(lottos);
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();
        showWinningStatistics(lottos, winningNumber.getNumbers(), bonusNumber.getNumber());
        long totalPrize = getTotalPrize(lottos, winningNumber.getNumbers(), bonusNumber.getNumber());
        showTotalProfit(totalPrize, money.getMoney());
    }

    private void showPurchasedLotto(final Lottos lottos) {
        PurchasedLottoResponse purchasedLottoResponse = PurchasedLottoResponse.from(lottos.getLottos());
        outputView.printPurchasedLottos(purchasedLottoResponse.getLottos());
    }

    private Money getMoney() {
        String money = inputView.readLine();
        return new Money(convertStringToInt(money));
    }

    private Lottos getLottos(final int money) {
        return Lottos.createWith(money, new RandomNumbersGenerator());
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


    private void showWinningStatistics(final Lottos lottos, final List<Integer> winningNumbers, final int bonusNumber) {
        outputView.printWinningStatistics(lottos.countFirstPrizeWinners(winningNumbers),
                lottos.countSecondPrizeWinners(winningNumbers, bonusNumber),
                lottos.countThirdPrizeWinners(winningNumbers),
                lottos.countFourthPrizeWinners(winningNumbers),
                lottos.countFifthPrizeWinners(winningNumbers));
    }

    private long getTotalPrize(final Lottos lottos, final List<Integer> winningNumbers, final int bonusNumber) {
        return lottos.calculateWinningTotalPrize(winningNumbers, bonusNumber);
    }

    private void showTotalProfit(final long totalPrize, final long money) {
        outputView.printTotalProfit(totalPrize, money);
    }

}
