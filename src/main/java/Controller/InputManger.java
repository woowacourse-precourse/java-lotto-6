package Controller;

public class InputManger {
    private int payment;
    private String input;


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
