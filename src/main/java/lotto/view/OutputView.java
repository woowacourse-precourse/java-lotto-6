package lotto.view;

import static lotto.view.GuideMessage.*;

public class OutputView {

    public void printPurchaseGuideMessage() {
        System.out.println(PURCHASE_GUIDE_MESSAGE.getText());
    }

    public void printWinningNumbersGuideMessage() {
        System.out.println(WINNING_NUMBERS_GUIDE_MESSAGE.getText());
    }

    public void printBonusNumberGuideMessage() {
        System.out.println(BONUS_NUMBER_GUIDE_MESSAGE.getText());
    }
}
