package lotto.domain;

public class PurchaseAmount {
    public Integer getAmount() {
        return amount;
    }

    private final Integer amount;

    public PurchaseAmount(final Integer amount){
        validate(amount);
        this.amount = amount;
    }

    private void validate(final Integer amount){
    }
}
