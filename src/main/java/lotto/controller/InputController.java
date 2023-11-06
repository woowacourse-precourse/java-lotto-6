package lotto.controller;

import java.util.List;
import lotto.Constants;
import lotto.model.PurchaseAmountValidator;
import lotto.model.Quantity;
import lotto.view.InputView;
import lotto.model.RandomLotto;

public class InputController {
        public static int setQuantity() {
                try {
                        PurchaseAmountValidator validation = new PurchaseAmountValidator(InputView.purchaseInput());
                        int purchaseAmount = Integer.parseInt(validation.PURCHASE_STRING);
                        Quantity quantity = new Quantity(purchaseAmount);
                        return quantity.quantityNum;
                } catch (IllegalArgumentException e) {
                        System.out.println(Constants.PURCHASE_WRONG_ERROR);
                        return setQuantity();
                }
        }

        public static List<List<Integer>> setRandomNumbers(int quantity) {
                RandomLotto randomLotto = new RandomLotto(quantity);
                return randomLotto.randomLotto;
        }

}
