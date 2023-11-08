package lotto.v3.controller;

import lotto.v3.model.LottoWinningNumber;
import lotto.v3.view.LottoWinningNumbersView;

public class LottoWinningNumberController {
    private final LottoWinningNumbersView lottoWinningNumbersView;

    public LottoWinningNumberController(LottoWinningNumbersView lottoWinningNumbersView) {
        this.lottoWinningNumbersView = lottoWinningNumbersView;
    }

    public LottoWinningNumber createWinningNumber() {
        while (true) {
            try {
                return new LottoWinningNumber(lottoWinningNumbersView.requestWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}


