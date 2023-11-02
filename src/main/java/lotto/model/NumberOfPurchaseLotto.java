package lotto.model;

public class NumberOfPurchaseLotto {
    private int numberOfPurchaseLotto;

    public NumberOfPurchaseLotto(int lottoPurchasePayment){
        int LOTTO_PRICE = 1000;
        this.numberOfPurchaseLotto = lottoPurchasePayment / LOTTO_PRICE;
    }

    public int getNumberOfPurchaseLotto(){
        return numberOfPurchaseLotto;
    }
}
