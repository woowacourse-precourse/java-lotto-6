package model;

public class Purchase {
    private final int LOTTO_PRICE = 1000;
    private int purchaseNumber;

    public void Number(int price) {
        priceCheck(price);
        purchaseNumber = price / LOTTO_PRICE;
    }

    private void priceCheck(int price){
        if(price % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public int getPurchaseNumber() {
        return purchaseNumber;
    }



}
