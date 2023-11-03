package lotto.domain;

public class Money {
    private static int purchaseAmount = 0;

    public Money(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        System.out.println(purchaseAmount);
    }



}
