package lotto.domain;

import lotto.view.Input;
import lotto.view.Print;

public class Seller {
    private Integer purchaseAmount;

    public void buy() {
        Print.getAmount();
        purchaseAmount = Input.getPurchaseAmount();
    }
}
