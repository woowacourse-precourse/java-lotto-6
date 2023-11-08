package lotto.v3.controller;

import lotto.v3.model.LottoBonusNumber;
import lotto.v3.model.LottoWinningNumber;
import lotto.v3.view.LottoBonusNumberView;

public class LottoBonusNumberController {
    private final LottoBonusNumberView lottoBonusNumberView;
    private final LottoWinningNumber winningNumber;

    public LottoBonusNumberController(LottoBonusNumberView lottoBonusNumberView, LottoWinningNumber winningNumber) {
        this.lottoBonusNumberView = lottoBonusNumberView;
        this.winningNumber = winningNumber;
    }

    public LottoBonusNumber createBonusNumber() {
        while (true) {
            try {
                int bonusNumber = lottoBonusNumberView.requestBonusNumber();
                return new LottoBonusNumber(bonusNumber, winningNumber.getNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
