package lotto.domain;

import lotto.util.validator.Validator;
import lotto.util.validator.ValidatorFactory;
import lotto.view.InputView;

public class Purchase {

    private final int purchase;

    public Purchase(int purchase) {
        this.purchase = purchase;
    }

    public static Purchase from(String rawPurchase) {
        int purchase = Integer.parseInt(rawPurchase);
        validate(purchase);
        return new Purchase(purchase);
    }

    private static void validate(int value) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getValidator(Purchase.class);
        validator.validate(value);
    }

    public int getPurchase() {
        return purchase;
    }
}
