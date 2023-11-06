package model;

public class Purchase {
    private final int LOTTO_PRICE = 1000;
    private int purchaseCount;
    private int purchasePrice;

    public void Number(int price) {
        priceCheck(price);
        purchasePrice = price;
        purchaseCount = price / LOTTO_PRICE;

    }

    private void priceCheck(int price){
        if(price % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다.");
        }
    }
    public int getPurchaseCount() {
        return purchaseCount;
    }



}
