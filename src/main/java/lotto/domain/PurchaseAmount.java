package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.util.Parser;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final String FORMAT_QUANTITY = "\n%d개를 구매했습니다.";
    int amount;

    public PurchaseAmount(String inputAmount) {
        int amount = Parser.parseSingleNumber(inputAmount);
        validate(amount);
        this.amount = amount;
    }

    public int getQuantity() {
        return amount / LOTTO_PRICE;
    }

    public String getResult() {
        int quantity = getQuantity();
        return String.format(FORMAT_QUANTITY, quantity);
    }

    private void validate(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_NUMBER.getMessage());
        }
        if ((amount % LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT.getMessage(LOTTO_PRICE));
        }
    }
}
