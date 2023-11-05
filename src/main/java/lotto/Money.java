package lotto;


public class Money {
    private static final int LOTTO_MIN_MONEY = 1000;
    private static final int ZERO_NUMBER = 0;

    private final int money;

    public Money(String inputMoney) {
        int amount = validateNumber(inputMoney);
        validateMoney(amount);
        this.money = amount;
    }

    private int validateNumber(String inputMoney) {
        inputBlank(inputMoney);
        return inputNumeric(inputMoney);
    }

    private void inputBlank(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private int inputNumeric(String inputMoney) {
        int amount;
        try {
            amount = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return amount;
    }

    private void validateMoney(int amount) {
        validatePositive(amount);
        validateRemainder(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= ZERO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRemainder(int amount) {
        if (amount % LOTTO_MIN_MONEY != ZERO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
