package lotto.util;

import lotto.domain.Customer;

public class TypeConverter {
    private static final int LOTTO_PRICE = 1000;

    public Customer convertStringToCustomer(String input) {
        int paymentAmount = toInt(input);
        validatePrice(paymentAmount);
        return createCustomer(paymentAmount);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NO_CHANGE_ERROR, e);
        }
    }

    private void validatePrice(int paymentAmount) {
        if (paymentAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASED_AMOUNT_INPUT_ERROR);
        }
    }

    private Customer createCustomer(int paymentAmount) {
        return new Customer(paymentAmount / LOTTO_PRICE, paymentAmount);
    }
}

