package lotto.domain;

public class PurchaseCost {

    private final long purchaseCost;

    public PurchaseCost(String purchaseCost) {

        long safePurchaseCost = validate(purchaseCost);
        this.purchaseCost = safePurchaseCost;
    }

    private long validate(String purchaseCost) {

        // 숫자가 아닌 경우

        // 로또 구입 금액이 0보다 작거나 같은 경우

        // 입력받은 로또 구입 금액을 1000천 단위로 입력 받지 않은 경우




        return Long.parseLong(purchaseCost)/1000;
    }


    public long getPurchaseCost() {
        return purchaseCost;
    }
}
