package lotto.domain;

public class Price {
    private static final int A_TICKET_PRICE = 1000;
    private static final int ZERO = 0;

    private int price;

    public Price(int purchaseAmount){
        this.price = purchaseAmount;
    }

    private int changeToPrice(int purchaseAmount){
        return purchaseAmount / A_TICKET_PRICE;
    }

    private void validateZERO(int purchaseAmount){
        if(purchaseAmount == ZERO){
            throw new IllegalArgumentException("금액이 0원입니다.");
        }
    }
}
