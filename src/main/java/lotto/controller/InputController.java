package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.WinnerNumber;
import lotto.view.InputViewBonusNumber;
import lotto.view.InputViewLottoPurchaseAmount;
import lotto.view.InputViewWinnerNumber;
import lotto.view.OutputView;

import java.util.List;

public class InputController {

    private LottoPurchaseAmount lottoPurchaseAmount;
    private BonusNumber bonusNumber;
    private WinnerNumber winnerNumber;

    public LottoPurchaseAmount getPurchaseAmount() {
        try {
            String purchase = InputViewLottoPurchaseAmount.getPurchaseAmount();
            lottoPurchaseAmount = new LottoPurchaseAmount(purchase);
            return lottoPurchaseAmount;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinnerNumber() {
        try {
            List<Integer> winnerNum = InputViewWinnerNumber.getWinnerNumber();
            winnerNumber = new WinnerNumber(winnerNum);
            return winnerNumber.getWinnerNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getWinnerNumber();
        }
    }

    public int getBonusNumber() {
        try {
            String bonusNum = InputViewBonusNumber.getBonusNumber();
            bonusNumber = new BonusNumber(bonusNum, winnerNumber.getWinnerNumber());
            return bonusNumber.getBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getBonusNumber();
        }
    }

}
