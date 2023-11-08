package lotto.model;

import java.util.List;
import java.util.logging.ErrorManager;

import lotto.view.ErrorMessage;

import java.util.Collections;

public class User {
    private List<Integer> user;
    private final static int MIN_PRICE = 1000;
    private int amount;
    private int count;

    public User(String amount) {
        int amountNum = validateNumber(amount);
        validate(amountNum);
        this.amount = amountNum;
        this.count = calculate_Count();
    }

    public int calculate_Count() {
        return this.amount / MIN_PRICE;
    }

    private static int validateNumber(String amount) throws IllegalArgumentException {

        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            ErrorMessage.number_Error();
            throw new IllegalArgumentException();
        }

    }

    private static void validate(int amount) {
        validateRange(amount);
        valiateDivide(amount);
    }

    private static void validateRange(int amount) throws IllegalArgumentException {
        if (amount < MIN_PRICE) {
            ErrorMessage.lotto_price_Error();
            throw new IllegalArgumentException();
        }
    }

    private static void valiateDivide(int amount) throws IllegalArgumentException {
        if (amount % MIN_PRICE != 0) {
            ErrorMessage.lotto_divide_Error();
            throw new IllegalArgumentException();
        }
    }
}
