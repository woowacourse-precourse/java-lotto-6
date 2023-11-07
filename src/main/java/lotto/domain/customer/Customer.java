package lotto.domain.customer;

import lotto.domain.lotto.Lotto;
import lotto.global.util.Validation;

import java.util.List;

public class Customer {
    private int price;
    private int quantity;
    private List<Lotto> lottos;  // lottos getter, setter 구현해야 함

    public Customer(String input) {
        int convertedInput = convertStringToInt(input);
        validate(convertedInput);
        price = convertedInput;
        setQuantity(price);
    }

    public int getQuantity() {
        return quantity;
    }

    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int price) {
        Validation validation = new Validation();
        validation.multipleOfThousand(price);
        validation.hundredThousandOrUnder(price);
    }

    private void setQuantity(int price) {
        quantity = price / 1000;
    }
}
