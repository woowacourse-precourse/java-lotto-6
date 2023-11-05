package lotto;


public class Money {
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
        int amount = 0;
        try {
            amount = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return amount;
    }

}
