package lotto.controller;

import static lotto.view.constant.ViewConstant.OutputViewConstant.AMOUNT;
import static lotto.view.constant.ViewConstant.OutputViewConstant.BONUS_NUMBER;
import static lotto.view.constant.ViewConstant.OutputViewConstant.WINNING_NUMBER;

import java.util.List;
import java.util.function.Supplier;
import lotto.view.BonusNumberInputView;
import lotto.view.OutputView;
import lotto.view.PurchaseAmountInputView;
import lotto.view.WinningNumberInputView;

public class LottoViewController {
    private final OutputView outputView = new OutputView();

    private <T> T retryInputOnException(final String order, final Supplier<T> supplier) {
        try {
            outputView.request(order);
            final T result = supplier.get();

            outputView.printNewLine();
            return result;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retryInputOnException(order, supplier);
        }
    }

    long receivePurchaseAmount() {
        PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();
        return retryInputOnException(AMOUNT, purchaseAmountInputView);
    }

    String receiveWinningNumber() {
        WinningNumberInputView winningNumberInputView = new WinningNumberInputView();
        return retryInputOnException(WINNING_NUMBER, winningNumberInputView);
    }

    int receiveBonusNumber(final String winningNumber) {
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView(winningNumber);
        return retryInputOnException(BONUS_NUMBER, bonusNumberInputView);
    }

    void printResultMessage(final List<Long> winCounts, final double earningRate) {
        outputView.printStatistics(winCounts);
        outputView.printEarningRate(earningRate);
    }

    void printUserLotto(final long lottoCount, final String allLotto) {
        outputView.printUserLotto(lottoCount, allLotto);
    }
}
