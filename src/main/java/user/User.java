package user;

import lotto.LottoCollection;

import static validate.InputValidation.*;

public class User {
    private final LottoCollection lottos;

    public User(int purchaseAmount) {
        validate(purchaseAmount);
        this.lottos = new LottoCollection(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        validateAmount(purchaseAmount);
    }

}
