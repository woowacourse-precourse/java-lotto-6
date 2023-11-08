package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;
import lotto.util.Parser;

public class PurchaseAmount implements LottoConstants {
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

    public double getReturnRate(double totalPrize) {
        return (totalPrize / (double) amount) * 100.0;
    }

    private void validate(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_NUMBER.toString());
        }
        if ((amount % LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT.toString());
        }
    }
}
