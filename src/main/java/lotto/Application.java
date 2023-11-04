package lotto;

import lotto.model.Purchase;
import lotto.model.RandomLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    private static int purchasePieces;
    private static List<Integer> lottoNum;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RandomLotto random = new RandomLotto();

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
            lottoNum = random.listSort(random.generateNum());
            outputView.purchaseNum(lottoNum);
        }
    }

    public static void main(String[] args) {
        purchaseCount(inputView.purchaseAmount());
        outputView.purchasePieces(purchasePieces);
        randomRepeat();
    }
}