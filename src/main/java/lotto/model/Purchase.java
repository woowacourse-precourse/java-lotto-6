package lotto.model;

public class Purchase {
    public static final String NUMBER_PATTERN = "[+-]?\\d+";

    private final int purchaseCount;

    private Purchase(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public static Purchase fromPurchaseAmount(String input) {
        validateNumeric(input);
        int purchaseCount = calculatePurchaseCount(Integer.parseInt(input));
        return new Purchase(purchaseCount);
    }

    private static int calculatePurchaseCount(int purchaseAmount) {
        validateAmountInThousands(purchaseAmount);
        return purchaseAmount / 1000;
    }

    private static void validateAmountInThousands(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자로만 이루어져야 합니다.");
        }
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
