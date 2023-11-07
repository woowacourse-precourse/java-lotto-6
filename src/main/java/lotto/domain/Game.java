package lotto.domain;

import java.util.List;

public class Game {
    private Validator validator;
    private Lottos lottos;

    public void issuance(Integer purchaseAmount) {
        validator.validatePurchaseAmount(purchaseAmount);
        lottos.inssuance(purchaseAmount);
    }

}
