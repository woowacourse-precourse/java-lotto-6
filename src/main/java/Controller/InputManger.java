package Controller;

import Model.InputModel;
import VIew.InputView;

public class InputManger {
    private int payment;
    private String input;
    private InputView inputView;

    public InputManger(InputView inputView) {
        this.inputView = inputView;
    }


    public int getPayment(String paymentAmount) {
        payment = Integer.parseInt(paymentAmount);
        return this.payment;

    }

    private boolean ensurePaymentIsCorrect(int payment) {
        if(payment % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }


}
