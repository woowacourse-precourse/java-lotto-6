package lotto.contoroller;

import lotto.domain.Purchase;
import lotto.utility.ChangeNumberType;
import lotto.view.InputValue;

public class LottoController {

    public void startLotto() {
        int purchaseAmount = getInputPurchase();
    }

    private int getInputPurchase() {
        while (true) {
            try {
                String input = InputValue.inputPurchase();
                int purchaseAmount = ChangeNumberType.changeNumberType(input);
                Purchase purchase = new Purchase(purchaseAmount);
                return purchase.getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
