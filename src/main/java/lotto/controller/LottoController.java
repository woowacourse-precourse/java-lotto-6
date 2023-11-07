package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningGrade;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;
import java.util.function.Supplier;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        buy();
        setWinning();
        compare();
        calculateYield();
    }

    private void buy() {
        outputView.printInputMoneyToBuyLottoMessage();
        Money money = readMoneyToBuyLotto();
        lottoService.buyLotto(money);
        outputView.printBoughtLottoCount(money.convertMoneyToCount());
        outputView.printLottos(lottoService.findBoughtLottos());
    }

    private void setWinning() {
        outputView.printInputWinningNumbersMessage();
        WinningNumbers winningNumbers = readWinningNumbers();
        outputView.printInputBonusNumberMessage();
        BonusNumber bonusNumber = readBonusNumber();
        lottoService.setWiningNumbers(winningNumbers, bonusNumber);
    }

    private void compare() {
        outputView.printWinningResultMessage();
        lottoService.compareAllLotto();
        outputView.printWinningResult(getWinningResult());
    }

    private void calculateYield() {
        outputView.printTotalYield(getCalculatedLottoYield());
    }

    private Map<WinningGrade, Integer> getWinningResult() {
        return lottoService.getWinningResult();
    }

    private double getCalculatedLottoYield() {
        return lottoService.calculateLottoYield();
    }

    private Money readMoneyToBuyLotto() {
        Supplier<Money> method = inputView::inputMoneyToBuyLotto;
        return retryUntilSuccess(method);
    }

    private WinningNumbers readWinningNumbers() {
        Supplier<WinningNumbers> method = inputView::inputWinningNumbers;
        return retryUntilSuccess(method);
    }

    private BonusNumber readBonusNumber() {
        Supplier<BonusNumber> method = inputView::inputBonusNumber;
        return retryUntilSuccess(method);
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        while(true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }
}
