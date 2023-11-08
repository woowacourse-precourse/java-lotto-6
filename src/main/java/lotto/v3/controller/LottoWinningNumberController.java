package lotto.v3.controller;

import lotto.v3.model.LottoWinningNumber;
import lotto.v3.view.LottoWinningNumbersView;

public class LottoWinningNumberController {
    private final LottoWinningNumbersView LottoWinningNumbersView;

    public LottoWinningNumberController(LottoWinningNumbersView LottoWinningNumbersView) {
        this.LottoWinningNumbersView = LottoWinningNumbersView;
    }

    public LottoWinningNumber createWinningNumber() {
        while (true) {
            try {
                return new LottoWinningNumber(LottoWinningNumbersView.requestWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }

}

