package lotto.validation;

public class PurchaseAmountValidator {

    private static final String BLANK_NOT_ALLOWED = "공백으로만 이루어진 문자열을 입력할 수 없습니다.";
    private static final String EMPTY_NOT_ALLOWED = "빈 문자열을 입력할 수 없습니다.";
    private static final String DIVISIBLE_BY_THOUSAND_ALLOWED = "1000원 단위만 입력할 수 있습니다.";
    private static final String ONLY_NUMBER_ALLOWED = "숫자만 입력할 수 있습니다.";

    private static final Integer LOTTO_PRICE = 1000;

    public void validatePurchaseAmount(String purchaseAmount) {
        validateBlank(purchaseAmount);
        validateEmpty(purchaseAmount);
        validateDivisibleByThousand(purchaseAmount);
    }

    private void validateBlank(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED);
        }
    }

    private void validateEmpty(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NOT_ALLOWED);
        }
    }

    private void validateDivisibleByThousand(String purchaseAmount) {
        Integer validatedIntegerPurchaseAmount = validateInteger(purchaseAmount);
        if ((validatedIntegerPurchaseAmount % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(DIVISIBLE_BY_THOUSAND_ALLOWED);
        }
    }

    private Integer validateInteger(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED);
        }
    }
}
