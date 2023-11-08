package lotto.domain;

import lotto.exception.ExceptionStatus;
import lotto.utils.StringValidator;

public class PurchaseQuantity {

    private final long amount;
    private final long lottoPurchases;

    private static final int ZERO = 0;

    public PurchaseQuantity(String amount) {

        validate(amount);

        this.amount = convertToLong(amount);
        this.lottoPurchases = calculateAvailableAmount(this.amount);
    }

    private void validate(String amount) {
        if (StringValidator.isBlank(amount) || !isDigit(amount)) {
            throw new IllegalArgumentException(ExceptionStatus.INPUT_COMMON_NOT_A_NUMBER.getMessage());
        }
        if (!isValidRange(amount)) {
            throw new IllegalArgumentException(ExceptionStatus.INPUT_AMOUNT_OUT_RANGE.getMessage());
        }
        if (!isThousandUnit(amount)) {
            throw new IllegalArgumentException(ExceptionStatus.INPUT_AMOUNT_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    private boolean isDigit(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private boolean isValidRange(String amount) {
        long convertedAmount = convertToLong(amount);
        return (0 < convertedAmount) && (convertedAmount < Long.MAX_VALUE);
    }

    private long convertToLong(String amount) {
        return Long.parseLong(amount);
    }

    private boolean isThousandUnit(String amount) {
        return (convertToLong(amount) % LottoPolicy.LOTTO_PRICE) == ZERO;
    }

    private long calculateAvailableAmount(long amount) {
        return amount / LottoPolicy.LOTTO_PRICE;
    }

    public long getAmount() {
        return amount;
    }

    public long getLottoPurchases() {
        return lottoPurchases;
    }
}
