package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.winning.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
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

    private List<String> getWinningResult() {
        return lottoService.getWinningResultMap();
    }

    private void calculateYield() {
        outputView.printTotalYield(getCalculatedLottoYield());
    }

    private double getCalculatedLottoYield() {
        return lottoService.calculateLottoYield();
    }

    private Money readMoneyToBuyLotto() {
        Supplier<Money> method = inputView::inputMoneyToBuyLotto;
        return readUntilSuccess(method);
    }

    private WinningNumbers readWinningNumbers() {
        Supplier<WinningNumbers> method = inputView::inputWinningNumbers;
        return readUntilSuccess(method);
    }

    private BonusNumber readBonusNumber() {
        Supplier<BonusNumber> method = inputView::inputBonusNumber;
        return readUntilSuccess(method);
    }

    private <T> T readUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }
}
