package lotto;

import lotto.model.Purchase;
import lotto.model.RandomLotto;
import lotto.view.InputView;

import java.io.PipedReader;
import java.net.CookieHandler;
import java.util.*;

public class Application {

    private static int purchasePieces;
    private static final InputView inputView = new InputView();

    public static void purchaseCount(String purchasingAmount) {
        try {
            purchasePieces = new Purchase(purchasingAmount).pieces();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseCount(purchasingAmount);
        }
    }

    public static void randomRepeat() {
        for (int i = 0; i < purchasePieces; i++) {
            RandomLotto random = new RandomLotto();
            System.out.println(random.listSort());
        }
    }

    public static void main(String[] args) {
        purchaseCount(inputView.purchaseAmount());
        randomRepeat();
    }
}