package lotto.domain;

import lotto.util.ErrorMessage;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final String FORMAT_QUANTITY = "\n%d개를 구매했습니다.";
    int amount;

    public PurchaseAmount(String inputAmount) {
        int amount = parseInput(inputAmount);
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

    private int parseInput(String input) {
        try {
            int amount = Integer.parseInt(input);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT.toString());
        }
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
