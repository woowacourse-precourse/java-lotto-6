package lotto.domain;

import lotto.constant.ConfigurationNumbers;
import lotto.constant.ExceptionMessage;

public class Pay {
    private int pay;

    public Pay(int pay) {
        validatePay(pay);
        this.pay = pay;
    }

    private void validatePay(int pay) {
        isNegative(pay);
        lessThanPrice(pay);
        divisibleByPrice(pay);
    }

    private void isNegative(int pay) {
        if (Integer.signum(pay) == ConfigurationNumbers.NEGATIVE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    private void lessThanPrice(int pay) {
        if (pay < ConfigurationNumbers.PRICE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.LESS_THAN_PRICE.getMessage());
        }
    }

    private void divisibleByPrice(int pay) {
        if (pay % ConfigurationNumbers.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAN_NOT_DIVIDE.getMessage());
        }
    }

    public int getLottoAmounts() {
        return pay / ConfigurationNumbers.PRICE.getNumber();
    }
}
