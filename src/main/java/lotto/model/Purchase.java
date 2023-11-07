package lotto.model;

public class Purchase {
    private static final int PURCHASING_UNIT = 1000;

    private final int purchasingAmount;

    public Purchase(String purchasingAmount) {
        this.purchasingAmount = validateAndParseAmount(purchasingAmount);
    }

    private int validateAndParseAmount(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        int amount = Integer.parseInt(input);
        if (amount % PURCHASING_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + PURCHASING_UNIT + "원 단위로 입력 가능합니다.");
        }
        return amount;
    }

    public int pieces() {
        return purchasingAmount / PURCHASING_UNIT;
    }
}