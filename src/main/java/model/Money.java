package model;

import config.ErrorMessage;

public class Money {

    private final int money;
    public final static int ROUND_DIGIT = 1;
    public final static int MONEY_UNIT = 1_000;

    public Money(String inputMoney) {
        int money = validateNumeric(inputMoney);
        validateMultiple(money);
        validatePositive(money);
        this.money = money;
    }

    public int getLottoNumber() {
        return money/MONEY_UNIT;
    }

    public String getYield(int winning) {
        String roundFormat = "%.".concat(Integer.toString(ROUND_DIGIT).concat("f"));
        return String.format(roundFormat, (double)winning * 100 / money).concat("%");
    }

    private int validateNumeric(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getErrorMessage());
        }
    }

    private void validateMultiple(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.NON_MULTIPLE.getErrorMessage(), MONEY_UNIT));
        }
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE.getErrorMessage());
        }
    }
}
