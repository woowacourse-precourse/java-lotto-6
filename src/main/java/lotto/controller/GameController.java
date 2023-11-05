package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.view.InputView;

public class GameController {

    public void start() {
        Purchase purchase = createPurchase();
        Lotto lotto = createLotto();
    }

    private Purchase createPurchase() {
        while (true) {
            try {
                int purchaseMoney = getPurchaseMoney();
                return new Purchase(purchaseMoney);
            } catch (IllegalArgumentException e) {
                InputView.printErrorMessage(e);
            }
        }
    }

    private int getPurchaseMoney() {
        return InputView.getPurchaseMoney();
    }

    private Lotto createLotto() {
        while (true) {
            try {
                List<Integer> numbers = getLottoNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                InputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> getLottoNumbers() {
        return InputView.getLottoNumbers();
    }
}