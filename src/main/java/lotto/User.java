package lotto;

public class User {

    private final int purchaseAmount;
    private int totalWinningAmount = 0;
    private int amountLotto;

    public User(int purchaseAmount) {
        validateMoneyInput(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.amountLotto = this.purchaseAmount/1000;
    }

    public int getAmountLotto() {
        return amountLotto;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTotalWinningAmount() {
        return totalWinningAmount;
    }

    public void addWinningAmount(int winningAmount) {
        this.totalWinningAmount += winningAmount;
    }

    void validateMoneyInput(int inputMoney) {

        String moneyInputErrorWarning = "[ERROR]로또 구입 금액으로 1000원 단위 이하는 입력 불가.";

        if(inputMoney%1000!=0) {
            throw new IllegalArgumentException(moneyInputErrorWarning);
        }

    }
}
