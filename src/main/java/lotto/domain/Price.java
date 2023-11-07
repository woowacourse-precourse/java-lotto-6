package lotto.domain;

public class Price {
    private static final int A_TICKET_PRICE = 1000;

    private int price;

    public Price(int purchaseAmount){
        this.price = purchaseAmount;
    }

    private int changeToPrice(int purchaseAmount){
        return purchaseAmount / A_TICKET_PRICE;
    }
}
