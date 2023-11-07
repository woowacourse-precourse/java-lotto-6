package lotto.util;

public class LottoPriceValidator {

    private static final int PRICE_OF_LOTTO = 1000;

    public static int validateTotalPriceOfLotto(String totalPriceOfLotto) {
        try {
            int totalPrice = Integer.parseInt(totalPriceOfLotto);
            validateIsPositiveNumber(totalPrice);
            validateIsDivisible(totalPrice);
            return totalPrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자가 입력되어야 합니다.");
        }
    }

    private static void validateIsDivisible(int totalPrice) {
        if (totalPrice % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1,000의 배수여야 합니다.");
        }
    }

    private static void validateIsPositiveNumber(int totalPrice) {
        if (totalPrice < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 양수가 입력되어야 합니다.");
        }
    }
}
