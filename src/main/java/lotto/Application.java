package lotto;

import lotto.model.Purchase;
import lotto.model.RandomLotto;
import lotto.view.InputView;

public class Application {

    private static String purchasingAmount;
    private static int purchasingPieces;

    private static final InputView inputView = new InputView();
    private static final RandomLotto random = new RandomLotto();

    public static void purchaseCount() {
        purchasingAmount = inputView.purchasingAmount();
        try {
            purchasingPieces = new Purchase(purchasingAmount).pieces();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseCount();
        }
    }

    public static void main(String[] args) {
        purchaseCount();
    }
}