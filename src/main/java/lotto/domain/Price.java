package lotto.domain;

public class Price{

    private final int purchasePrice;

    public Price(int purchasePrice){
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(int purchasePrice){
    }

    double calculateEarningRate(int winningPrice){
        return -1;
    }

}
