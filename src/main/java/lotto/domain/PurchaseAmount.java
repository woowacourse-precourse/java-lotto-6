package lotto.domain;

import static lotto.utils.constants.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.constants.ErrorMessageConstants.NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.utils.constants.ErrorMessageConstants.NUMBER_UNIT_ERROR_MESSAGE;
import static lotto.utils.constants.LottoConstants.LOTTO_TICKET_PRICE;
import static lotto.utils.constants.LottoConstants.MAXIMUM_PURCHASE_AMOUNT;
import static lotto.utils.constants.LottoConstants.MINIMUM_PURCHASE_AMOUNT;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateUnit(amount);
        validatePurchaseRange(amount);
    }

    private static void validatePurchaseRange(int purchaseAmount) {
        if (purchaseAmount < MINIMUM_PURCHASE_AMOUNT || purchaseAmount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + NUMBER_UNIT_ERROR_MESSAGE);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getTicketQuantity() {
        return amount / LOTTO_TICKET_PRICE;
    }

}
