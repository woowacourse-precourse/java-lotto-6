package lotto.Domain;

import lotto.Constants.ExceptionMessage;

public class LottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private void checkZero(int amount){
        if (amount <= ZERO){
            throw ExceptionMessage.INPUT_ZERO.throwexception();
        }
    }

    private int checkLottoPrice(int amount){
        if (amount % LOTTO_PRICE != 0){
            throw ExceptionMessage.DIVISION_THOUSAND.throwexception();
        }
        return amount / LOTTO_PRICE;
    }
}
