package lotto;

import lotto.EnumList.ConstantErrorMessage;

public class Money {

    private int money = 0;
    private static final int ONE_THOUSAND_WON = 1000;
    private static final int ZERO = 0;

    public Money(String money) {
        this.money = validate(money);
    }

    public int currentMoney() {
        return money;
    }

    private int validate(String money) {
        validateMoney(money);
        validateRealMoney(money);

        return moneySize(money);
    }

    private void validateMoney(String money) {
        if(!money.matches("[0-9]+")) {
            throw new IllegalArgumentException(ConstantErrorMessage.ERROR_NUMBER.errorMessage());
        }
    }

    private void validateRealMoney(String money) {
        if(money.charAt(0) == '0') {
            throw new IllegalArgumentException(ConstantErrorMessage.ERROR_NUMBER.errorMessage());
        }
    }

    private int moneySize(String money) {
        int realMoney = Integer.parseInt(money);

        if(realMoney % ONE_THOUSAND_WON != ZERO) {
            throw new IllegalArgumentException(ConstantErrorMessage.ERROR_INSERT_WON.errorMessage());
        }

        return realMoney;
    }
}
