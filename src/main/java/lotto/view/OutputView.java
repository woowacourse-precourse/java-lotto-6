package lotto.view;


import java.util.List;
import lotto.domain.Lotto;

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

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
