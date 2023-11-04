package lotto.model.collections;

public class LottoPurchaseAmount {
    private final int amount;

    public LottoPurchaseAmount(String amount) {
        //검증 로직
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount(){
        return amount;
    }
}
