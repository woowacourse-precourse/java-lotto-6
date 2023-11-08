package lotto.domain;

import static lotto.constants.ErrorMessage.INSUFFICIENT_BALANCE;
import static lotto.constants.ErrorMessage.INVALID_AMOUNT;
import static lotto.constants.LottoOption.LOTTO_TICKET_PRICE;

public class Balance {
    private int amount;
    private final int purchaseAmount;

    private Balance(int amount) {
        validatePurchaseWithoutChange(amount);
        this.amount = amount;
        this.purchaseAmount = amount;
    }

    public static Balance create(int amount) {
        return new Balance(amount);
    }

    public boolean hasSufficientBalance() {
        return amount >= LOTTO_TICKET_PRICE.getValue();
    }

    public void deductTicketPrice() {
        if (!hasSufficientBalance()) {
            throw new IllegalStateException(INSUFFICIENT_BALANCE.getMessage());
        }

        amount -= LOTTO_TICKET_PRICE.getValue();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validatePurchaseWithoutChange(int amount) {
        if (isNotMultipleOfTicketPrice(amount)) {
            throw new IllegalArgumentException(
                    String.format(INVALID_AMOUNT.getMessage(), LOTTO_TICKET_PRICE.getValue()));
        }
    }

    private boolean isNotMultipleOfTicketPrice(int amount) {
        return amount % LOTTO_TICKET_PRICE.getValue() != 0;
    }
}
