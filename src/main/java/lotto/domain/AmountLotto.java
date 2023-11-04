package lotto.domain;

public class AmountLotto {
    private static final int lottoAmount = 1000;
    private int amount;

    public AmountLotto(String amount){
        this.amount = Integer.parseInt(amount);
    }
    public int getAmount() {
        return amount;
    }

    public int calculateAmountLotto(){
        return amount / lottoAmount;
    }
}
