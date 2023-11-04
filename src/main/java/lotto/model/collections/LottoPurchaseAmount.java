package lotto.model.collections;

public class LottoPurchaseAmount {
    private final int amount;

    public LottoPurchaseAmount(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(String amount) {
        //검증 로직
    }

    public int getAmount() {
        return amount;
    }
}
