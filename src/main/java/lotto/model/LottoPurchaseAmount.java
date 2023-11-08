package lotto.model;

import static lotto.constant.Amount.MAXIMUM_PURCHASE_AMOUNT;
import static lotto.constant.Amount.THOUSAND;
import static lotto.constant.ErrorMessage.CONTAINING_OTHER_THAN_NUMBER;
import static lotto.constant.ErrorMessage.EXCEEDING_MAXIMUM_PURCHASE;
import static lotto.constant.StringPattern.NUMBER_PATTERN;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.constant.ErrorMessage;

public class LottoPurchaseAmount {
    private final BigDecimal amount;

    private LottoPurchaseAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public static LottoPurchaseAmount from(final String input) {
        validateNumeric(input);
        BigDecimal purchaseAmount = convertToBigDecimalFrom(input);
        validateMaximumPurchase(purchaseAmount);
        validateMultipleOf1000(purchaseAmount);
        return new LottoPurchaseAmount(purchaseAmount);
    }

    private static BigDecimal convertToBigDecimalFrom(final String input) {
        long temporaryValue = Long.parseLong(input);
        return BigDecimal.valueOf(temporaryValue);
    }

    private static void validateNumeric(final String input) {
        if (NUMBER_PATTERN.isNotMatching(input)) {
            throw new IllegalArgumentException(CONTAINING_OTHER_THAN_NUMBER.getMessage());
        }
    }

    private static void validateMaximumPurchase(final BigDecimal input) {
        if (MAXIMUM_PURCHASE_AMOUNT.isUnder(input)) {
            throw new IllegalArgumentException(EXCEEDING_MAXIMUM_PURCHASE.getMessage());
        }
    }

    private static void validateMultipleOf1000(final BigDecimal purchaseAmount) {
        if (THOUSAND.isNotDivisorOf(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLES_OF_ONE_THOUSAND.getMessage());
        }
    }

    public LottoPurchaseQuantity getLottoPurchaseQuantity() {
        BigDecimal quantity = amount.divide(THOUSAND.getAmount(), RoundingMode.FLOOR);
        return new LottoPurchaseQuantity(quantity.intValueExact());
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
