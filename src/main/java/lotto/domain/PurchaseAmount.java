package lotto.domain;

public class PurchaseAmount {
    public static final int PRICE_PER_ONE_LOTTO = 1000;
    Integer amount;
    Integer numberOfLotto;

    public PurchaseAmount(Integer amount) {
        validate(amount);
        this.amount = amount;
        this.numberOfLotto = amount / PRICE_PER_ONE_LOTTO;
    }
    
    private void validate(Integer amount) {
        
    }
}
