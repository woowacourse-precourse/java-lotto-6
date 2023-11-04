package lotto.contoroller;

import lotto.domain.Purchase;
import lotto.view.InputValue;

public class LottoController {

    public void StartLotto() {
        int input = InputValue.inputPurchase();
        new Purchase(input);
    }
}
