package model;

import utils.Converter;

public class LottoVendor {
    private static final int LOTTO_AMOUNT = 1000;
    private static final String CAN_NOT_DIVIDE = "[ERROR] 1000으로 나누어 떨어지지 않습니다.";
    public LottoVendor(String purchaseAmount) {
        validationDivide(Converter.stringToInt(purchaseAmount));
    }

    public void validationDivide(int purchaseAmount) {
        if (purchaseAmount % LOTTO_AMOUNT > 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE);
        }
    }
}
