package lotto.domain;

import static lotto.constant.ErrorMessage.NOT_DIVIDE;
import static lotto.constant.ErrorMessage.STRANGE_INTEGER;


public class LottoPurchase {

    private final int payment;

    public LottoPurchase(int payment){
        validatePayment(payment);
        this.payment = payment;
    }

    private void validatePayment(int payment) {
        checkDivisibleByTicketPrice(payment);
        ensurePositivePayment(payment);
    }

    private void checkDivisibleByTicketPrice(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE.getMessage());
        }
    }

    private void ensurePositivePayment(int payment) {
        if (payment <= 0) {
            throw new IllegalArgumentException(STRANGE_INTEGER.getMessage());
        }
    }
    public int getPayment(){
        return payment;
    }
}
