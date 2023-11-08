package lotto.controller.lotto;

import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.exception.LottoException;
import lotto.view.input.LottoPurchaseInputView;
import lotto.view.output.LottoPurchaseOutputView;

public class LottoPurchaseController {
    private final LottoPurchaseInputView lottoPurchaseInputView;
    private final LottoPurchaseOutputView lottoPurchaseOutputView;

    public LottoPurchaseController(
            final LottoPurchaseInputView lottoPurchaseInputView,
            final LottoPurchaseOutputView lottoPurchaseOutputView
    ) {
        this.lottoPurchaseInputView = lottoPurchaseInputView;
        this.lottoPurchaseOutputView = lottoPurchaseOutputView;
    }

    public LottoPurchaseAmount purchase() {
        lottoPurchaseOutputView.printInputPurchasingAmountMessage();
        final LottoPurchaseAmount lottoPurchaseAmount = readLottoPurchaseAmount();
        lottoPurchaseOutputView.printNewLine();
        return lottoPurchaseAmount;
    }

    private LottoPurchaseAmount readLottoPurchaseAmount() {
        try {
            return lottoPurchaseInputView.readLottoPurchaseAmount();
        } catch (LottoException exception) {
            return readLottoPurchaseAmount();
        }
    }
}
