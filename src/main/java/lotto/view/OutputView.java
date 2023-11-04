package lotto.view;


public class OutputView {

    public void printPurchaseGuideMessage() {
        System.out.println(GuideMessage.PURCHASE_GUIDE_MESSAGE.getText());
    }

    public void printWinningNumbersGuideMessage() {
        System.out.println(GuideMessage.WINNING_NUMBERS_GUIDE_MESSAGE.getText());
    }

    public void printBonusNumberGuideMessage() {
        System.out.println(GuideMessage.BONUS_NUMBER_GUIDE_MESSAGE.getText());
    }
}
