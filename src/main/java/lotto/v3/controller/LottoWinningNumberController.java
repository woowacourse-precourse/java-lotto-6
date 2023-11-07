package lotto.v3.controller;

import lotto.v3.model.LottoWinningNumber;
import lotto.v3.view.LottoWinningNumbersView;

public class LottoWinningNumberController {
    private final LottoWinningNumbersView lottoWinningNumbersView;

    public LottoWinningNumberController(LottoWinningNumbersView lottoWinningNumbersView) {
        this.lottoWinningNumbersView = lottoWinningNumbersView;
    }

    public LottoWinningNumber createWinningNumber() {
        return new LottoWinningNumber(lottoWinningNumbersView.requestWinningNumbers());
    }
}

