package lotto.exception;

import lotto.util.Converter;

public class LottoPurchaseAmountException {
    private static final String CAN_DIVIDE_THOUSAND_MESSAGE = "구매 금액은 1,000으로 나누어 떨어져야 합니다.";
    private Converter converter = new Converter();

    public void isDivideThousand(String input) {
        int purchaseAmount = converter.stringToInteger(input);
        if(purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(CAN_DIVIDE_THOUSAND_MESSAGE);
        }
    }

    public void isNumber(String input) {
    }

    public void isBlank(String input) {
    }
}
