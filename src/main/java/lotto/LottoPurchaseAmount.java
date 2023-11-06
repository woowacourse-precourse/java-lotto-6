package lotto;

import exception.LottoException;

public class LottoPurchaseAmount {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int ZERO = 0;

    private int purchaseAmount;

    public LottoPurchaseAmount() {
    }

    public LottoPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = validate(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private int validate(String purchaseAmount) {
        int amount = validateInt(purchaseAmount);
        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int price) {
        if (price <= ZERO) {
            throw new IllegalArgumentException(LottoException.NOT_POSITIVE_NUMBER);
        }
        if ((price % LOTTO_TICKET_PRICE) != ZERO) {
            throw new IllegalArgumentException(LottoException.NOT_DIVIDE_LOTTO_TICKET_PRICE);
        }
    }

    private int validateInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoException.NOT_NUMBER);
        }
    }
}
