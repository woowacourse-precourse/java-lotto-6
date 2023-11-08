package lotto.controller;

import static lotto.view.constant.ViewConstant.OutputViewConstant.AMOUNT;
import static lotto.view.constant.ViewConstant.OutputViewConstant.BONUS_NUMBER;
import static lotto.view.constant.ViewConstant.OutputViewConstant.WINNING_NUMBER;

import java.util.List;
import java.util.function.Supplier;
import lotto.view.BonusNumberInputView;
import lotto.view.LottoOutputView;
import lotto.view.PurchaseAmountInputView;
import lotto.view.WinningNumberInputView;

public class LottoViewController {
    private final LottoOutputView lottoOutputView = new LottoOutputView();

    private <T> T retryInputOnException(final String order, final Supplier<T> supplier) {
        try {
            lottoOutputView.request(order);
            final T result = supplier.get();

            lottoOutputView.printNewLine();
            return result;
        } catch (IllegalArgumentException e) {
            lottoOutputView.printErrorMessage(e.getMessage());
            return retryInputOnException(order, supplier);
        }
    }

    Long receivePurchaseAmount() {
        final PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();
        return retryInputOnException(AMOUNT, purchaseAmountInputView);
    }

    String receiveWinningNumber() {
        final WinningNumberInputView winningNumberInputView = new WinningNumberInputView();
        return retryInputOnException(WINNING_NUMBER, winningNumberInputView);
    }

    Integer receiveBonusNumber(final String winningNumber) {
        final BonusNumberInputView bonusNumberInputView = new BonusNumberInputView(winningNumber);
        return retryInputOnException(BONUS_NUMBER, bonusNumberInputView);
    }

    void printResultMessage(final List<Long> winCounts, final double earningRate) {
        lottoOutputView.printStatistics(winCounts);
        lottoOutputView.printEarningRate(earningRate);
    }

    void printUserLotto(final long lottoCount, final String allLotto) {
        lottoOutputView.printUserLotto(lottoCount, allLotto);
    }
}
