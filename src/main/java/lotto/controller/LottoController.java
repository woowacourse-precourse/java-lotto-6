package lotto.controller;

import lotto.model.LottoModel;
import lotto.validate.PurchaseAmountValidation;
import lotto.validate.WinningNumberValidation;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoModel lottoModel;

    public LottoController(final LottoInputView lottoInputView, final LottoOutputView lottoOutputView, final LottoModel lottoModel) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoModel = lottoModel;
    }

    public void startGame() {
        lottoOutputView.printUserInputPurchaseAmount();
        int purchaseAmount = lottoInputView.inputPurchaseAmount(new PurchaseAmountValidation());

        lottoOutputView.printUserInputWinningNumber();
        List<Integer> winningNumbers = lottoInputView.inputWinningNumber(new WinningNumberValidation());
    }
}
