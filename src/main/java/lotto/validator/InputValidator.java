package lotto.validator;

import lotto.domain.Constants;

public class InputValidator {
    Constants constants = new Constants();

    public void checkAmount(String amountInput) {
        checkAmountNumber(amountInput);
        checkAmountPositiveNumber(Integer.parseInt(amountInput));
        checkDividedNumber(Integer.parseInt(amountInput));
    }

    private void checkAmountNumber(String amountInput) {
        for (int i = 0; i < amountInput.length(); i++) {
            char c = amountInput.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.printf(constants.LOTTO_PRICE_NOT_NUMBER_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkAmountPositiveNumber(int amountInput) {
        if(amountInput <= 0) {
            System.out.printf(constants.LOTTO_PRICE_NOT_POSITIVE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    //1000으로 나누어떨어지는지 확인
    private void checkDividedNumber(int amountInput) {
        if(amountInput % 1000 != constants.ZERO_NUMBER) {
            System.out.printf(constants.LOTTO_PRICE_NOT_DIVIDED_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
