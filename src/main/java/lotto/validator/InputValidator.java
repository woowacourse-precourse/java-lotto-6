package lotto.validator;

import lotto.domain.Constants;

public class InputValidator {

    Constants constants = new Constants();

    public void checkAmount(String amountInput) {
        checkAmountNum(amountInput);
        checkDividedNum(Integer.parseInt(amountInput));
    }

    //숫자인지 확인
    private void checkAmountNum(String amountInput) {
        for (int i = 0; i < amountInput.length(); i++) {
            char c = amountInput.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.printf(constants.LOTTO_PRICE_NOT_NUMBER_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }

    //1000으로 나누어떨어지는지 확인
    private void checkDividedNum(int amountInput) {
        if(amountInput % 1000 != constants.ZERO_NUMBER) {
            System.out.printf(constants.LOTTO_PRICE_NOT_DIVIDED_ERROR);
            throw new IllegalArgumentException();
        }
    }




}
