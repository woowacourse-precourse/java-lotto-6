package lotto.model;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount){
        if(purchaseAmount%1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public int lottoCount(){
        return purchaseAmount/1000;
    }

}
