package lotto.controller;

public class LottoGame {
    private final InputDevice inputDevice = new InputDevice();

    public void run(){
        Integer payment = inputDevice.inputLottoPurchasePayment();
        System.out.println(payment);
    }
}
