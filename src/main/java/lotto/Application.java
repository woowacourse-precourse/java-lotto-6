package lotto;

import lotto.model.Purchase;
import lotto.view.InputView;

import java.util.*;

public class Application {

    private static String purchasingAmount;

    private static final InputView inputView = new InputView();

    public static void purchaseCount() {
        purchasingAmount =inputView.purchasingAmount();
        try {
            Purchase purchase = new Purchase(purchasingAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseCount();
        }
    }

    public static void main(String[] args) {
        purchaseCount();
    }
}