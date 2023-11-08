package lotto.domain;

public class Player {
    private int purChaseAmount;

    public void insertPurchaseAmount(int purChaseAmountInput) {
        this.purChaseAmount = purChaseAmountInput;
    }

    public int getPurChaseAmount() {
        return purChaseAmount;
    }
}
