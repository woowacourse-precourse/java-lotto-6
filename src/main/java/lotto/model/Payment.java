package lotto.model;

import lotto.validator.PaymentValidator;

import java.util.regex.Pattern;

public class Payment {
    private final int price;

    public Payment(String input) {
        PaymentValidator.validate(input);
        this.price = Integer.parseInt(input);
    }

}
