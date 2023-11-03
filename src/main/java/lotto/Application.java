package lotto;

import lotto.model.Purchase;
import lotto.model.RandomLotto;
import lotto.view.InputView;

import java.io.PipedReader;
import java.net.CookieHandler;
import java.util.*;

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

    public static List<Integer> listSort(List<Integer> noSort) {
        List<Integer> listSort = new ArrayList<>(noSort);
        Collections.sort(listSort);
        return listSort;
    }

    public static void main(String[] args) {
        purchaseCount();
        for (int i = 0; i < purchasingPieces; i++) {
            listSort(random.generateNum());
        }
    }
}