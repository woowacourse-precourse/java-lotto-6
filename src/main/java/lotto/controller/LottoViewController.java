package lotto.controller;

import static lotto.view.constant.ViewConstant.OutputViewConstant.AMOUNT;
import static lotto.view.constant.ViewConstant.OutputViewConstant.BONUS_NUMBER;
import static lotto.view.constant.ViewConstant.OutputViewConstant.WINNING_NUMBER;

import java.util.List;
import java.util.function.Supplier;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoViewController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private <T> T receive(final String order, final Supplier<T> supplier) {
        try {
            outputView.request(order);
            final T result = supplier.get();

            outputView.printNewLine();
            return result;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return receive(order, supplier);
        }
    }

    long receivePurchaseAmount() {
        return receive(AMOUNT, inputView::receivePurchaseAmount);
    }

    String receiveWinningNumber() {
        return receive(WINNING_NUMBER, inputView::receiveWinningNumber);
    }

    int receiveBonusNumber(final String winningNumber) {
        return receive(BONUS_NUMBER, () -> inputView.receiveBonusNumber(winningNumber));
    }

    void printResultMessage(final List<Long> winCounts, final double earningRate) {
        outputView.printStatistics(winCounts);
        outputView.printEarningRate(earningRate);
    }

    void displayUserLotto(final long lottoCount, final String allLotto) {
        outputView.printUserLotto(lottoCount, allLotto);
    }
}
