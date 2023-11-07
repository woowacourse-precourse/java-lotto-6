package controller;

import view.LottoPurchaseInputView;

public class LottoController {
    public void gameStart() {
        LottoPurchaseInputView lottoPurchaseInputView = new LottoPurchaseInputView();

        lottoPurchaseInputView.readLottoPurchaseValidator();
    }
}
