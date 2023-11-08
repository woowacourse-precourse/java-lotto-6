package lotto.domain;

public class Player {
    private int purChaseAmount;

    public void insertPurchaseAmount(int purChaseAmountInput) {
        this.purChaseAmount = purChaseAmountInput;
    }

    public int getPurChaseAmount() {
        return purChaseAmount;
    }

    public double calculateRateOfReturn(double totalReturn) {
        double rateOfReturn = (totalReturn / purChaseAmount) * 100.0;
        rateOfReturn = Math.round(rateOfReturn * 100.0) / 100.0;

        return rateOfReturn;
    }
}
