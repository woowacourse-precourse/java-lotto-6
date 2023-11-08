package lotto.service;

import lotto.view.Exception_Message;

public class PlayerTickets {

    private static final int lotto_purchase_unit = 1000;
    private final int amount;

    private static int check_input(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            Exception_Message.exception_check_input_equals_integer();
            throw new IllegalArgumentException();
        }
    }

    private void check_amount_if_ERROR(int amount) {
        check_amount_can_divide(amount);
        check_amount_positive_number(amount);
    }

    private void check_amount_positive_number(int amount) {
        if (amount <= 0) {
            Exception_Message.exception_check_input_equals_positive_number();
            throw new IllegalArgumentException();
        }
    }

    private void check_amount_can_divide(int amount) {
        if (amount % lotto_purchase_unit != 0) {
            Exception_Message.exception_check_input_equals_satisfy_unit();
            throw new IllegalArgumentException();
        }
    }

    public PlayerTickets(String amount) {
        int amount_number = check_input(amount);
        check_amount_if_ERROR(amount_number);
        this.amount = amount_number;
    }

    public int divide_per_lotto_purchase_unit() {
        return amount / lotto_purchase_unit;
    }
}
