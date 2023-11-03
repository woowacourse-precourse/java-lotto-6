package lotto.model;

public class Purchase {

    private int PURCHASING_UINT = 1000;

    private final String purchasingAmount;
    public Purchase(String purchasingAmount) {
        this.purchasingAmount = purchasingAmount;
        validateNum(this.purchasingAmount);
        validateUnit(this.purchasingAmount);
    }

    public void validateNum(String purchasingAmount) {
        if (purchasingAmount.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void validateUnit(String purchasingAmount) {
        if (Integer.parseInt(purchasingAmount) % PURCHASING_UINT != 0) {
            throw new IllegalArgumentException("[ERROR] " + PURCHASING_UINT + "원 단위로 입력 가능합니다.");
        }
    }

    public int pieces() {
        return Integer.parseInt(purchasingAmount) / PURCHASING_UINT;
    }
}
