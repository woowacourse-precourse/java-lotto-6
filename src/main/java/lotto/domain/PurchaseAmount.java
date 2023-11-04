package lotto.domain;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        // 유효성 검증 로직
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}