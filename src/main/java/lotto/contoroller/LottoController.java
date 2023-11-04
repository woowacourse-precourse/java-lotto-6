package lotto.contoroller;

import lotto.domain.Purchase;
import lotto.view.InputValue;

public class LottoController {

    public void StartLotto() {
        String input = InputValue.inputPurchase();
        int number = Integer.parseInt(input);
        new Purchase(number);
    }
}
