package lotto.model;

public class NumberOfPurchaseLotto {
    private int numberOfPurchaseLotto;

    public NumberOfPurchaseLotto(int LottoPurchasePayment){
        int LOTTO_PRICE = 1000;
        this.numberOfPurchaseLotto = LottoPurchasePayment / LOTTO_PRICE;
    }

    public int getNumberOfPurchaseLotto(){
        return numberOfPurchaseLotto;
    }
}
