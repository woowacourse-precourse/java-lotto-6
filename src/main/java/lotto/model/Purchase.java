package lotto.model;

public class Purchase {

    private String purchasingAmount;
    public Purchase(String purchasingAmount) {
        this.purchasingAmount = purchasingAmount;
        validateUnit(this.purchasingAmount);
    }

    public void validateUnit(String purchasingAmount) {
        if (Integer.parseInt(purchasingAmount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능합니다.");
        }
    }
}
