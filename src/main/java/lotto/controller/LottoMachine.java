package lotto.controller;

public class LottoMachine {
    private LottoPurchase lottoPurchase;

    public LottoMachine() {
        lottoPurchase = new LottoPurchase();
    }

    public void start(){
        lottoPurchase.inputAmount();
    }
}
