package lotto.domain;

import static lotto.error.ErrorMessage.*;

import lotto.error.ErrorMessage;

public class Game {
    private Validator validator;

    public void issuance(Integer purchaseAmount) {
        validator.validatePurchaseAmount(purchaseAmount);

    }

}
