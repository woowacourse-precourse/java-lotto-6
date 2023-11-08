package lotto.model;

public class Purchase {

    private static final int PURCHASING_UNIT = 1000;
    private static final String INPUT_CONTENT_REGEX = "^[0-9]+$";

    private final int purchasingAmount;

    public Purchase(String purchasingAmount) {
        validateNum(purchasingAmount);
        this.purchasingAmount = validateUnit(purchasingAmount);
    }

    private void validateNum(String input) {
        if (!input.matches(INPUT_CONTENT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private int validateUnit(String input) {
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