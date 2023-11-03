package lotto.domain;

import lotto.validator.InputValidator;

public class PurchasePrice {
    //static 적어주어야하나

    private final int price;

    private PurchasePrice(String input) {
        validate(input);
        price = Integer.parseInt(input);
    }

    public static PurchasePrice from(String input) {
        return new PurchasePrice(input);
    }

    private void validate(String input) {
        InputValidator.onlyNumber(input);
        InputValidator.inRange(input);
        InputValidator.divisibleUnit(Integer.parseInt(input));
    }

    public int getPrice() {
        return price;
    }
}
