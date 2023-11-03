package lotto.service;

import lotto.utils.Validator;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;
    public int amount;

    public void getAmount(String userInput) {
        checkAmount(userInput);
    }

    private void checkAmount(String userInput) {
        int amount;
        Validator.validateStringIsNumber(userInput);
        amount = Integer.parseInt(userInput);
        Validator.validateDivisor(amount, LOTTO_PRICE);
        this.amount = amount;
    }
}
