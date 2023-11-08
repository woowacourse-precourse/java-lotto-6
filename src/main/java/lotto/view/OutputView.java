package lotto.view;

import static lotto.view.OutputMessage.*;

public class OutputView {
    public void askPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public void askLottoWinningNumber() {
        printNewLine();
        System.out.println(ENTER_LOTTO_NUMBERS.getMessage());
    }

    public void askBonusNumber() {
        printNewLine();
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
}