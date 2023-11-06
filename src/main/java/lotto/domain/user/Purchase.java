package lotto.domain.user;

public class Purchase {
    private static int purchaseAmount;

    public Purchase(String amount) {
        validate(amount);
        purchaseAmount = Integer.parseInt(amount);
    }

    public static void validate(String amount) {
        validateIsNumber(amount);
        validateIsDivisibleBy1000(amount);
        validateIsPositiveInteger(amount);
    }

    private static void validateIsNumber(String amount) {
        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateIsDivisibleBy1000(String amount) {
        if((Double.parseDouble(amount) % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    private static void validateIsPositiveInteger(String amount) {
        if(Double.parseDouble(amount) <= 0) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        }
    }

    public Integer getLottoPurchase() {
        return purchaseAmount;
    }
}