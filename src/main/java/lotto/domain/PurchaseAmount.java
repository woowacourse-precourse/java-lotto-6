package lotto.domain;

import static lotto.utils.ConstantValues.LOTTO_PRICE;
import static lotto.utils.ConstantValues.MAX_NUMBER_OF_LOTTOS;
import static lotto.utils.ConstantValues.NO_PURCHASE_AMOUNT;
import static lotto.utils.ConstantValues.NO_REMAINING_CHANGE;
import static lotto.utils.ConstantValues.PERCENTAGE_MULTIPLIER;
import static lotto.utils.ErrorMessages.CHANGE_REMAINING;
import static lotto.utils.ErrorMessages.PURCHASE_AMOUNT_LESS_THAN_OR_EQUAL_TO_ZERO;
import static lotto.utils.ErrorMessages.TOO_MUCH_PURCHASE_AMOUNT;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        validateMoreThanZero(purchaseAmount);
        validateChangeNoRemaining(purchaseAmount);
        validateNotTooMuchPurchaseAmount(purchaseAmount);
    }

    private void validateMoreThanZero(int purchaseAmount) {
        if (purchaseAmount <= NO_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_LESS_THAN_OR_EQUAL_TO_ZERO);
        }
    }

    private void validateChangeNoRemaining(int purchaseAmount) {
        if ((purchaseAmount % LOTTO_PRICE) > NO_REMAINING_CHANGE) {
            throw new IllegalArgumentException(CHANGE_REMAINING);
        }
    }

    private void validateNotTooMuchPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount > (LOTTO_PRICE * MAX_NUMBER_OF_LOTTOS)) {
            throw new IllegalArgumentException(String.format(TOO_MUCH_PURCHASE_AMOUNT, MAX_NUMBER_OF_LOTTOS));
        }
    }

    public int getAvailableLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public double calculateProfitRate(long totalProfit) {
        return (totalProfit / (double) purchaseAmount) * PERCENTAGE_MULTIPLIER;
    }
}
