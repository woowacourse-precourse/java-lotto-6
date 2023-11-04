package lotto.controller;

import lotto.view.OutputView;

public class LottoCompareSite {
    private final OutputView outputView = new OutputView();

    public void access() {
        outputView.printInputWinningNumbers();
    }
}
