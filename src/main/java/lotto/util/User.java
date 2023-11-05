package lotto.util;


public class User {
    private static int paymentAmount;

    public void inputPaymentAmount(String input) {
        paymentAmount = Exception.checkInvalidNumber(input);
        checkPaymentAmount(paymentAmount);
    }

    public void checkPaymentAmount(int paymentAmount){
        Exception.checkUnitPaymentAmount(paymentAmount);
        Exception.checkRangePaymentAmount(paymentAmount);
    }

    public int getManyLottoTicket() {
        return paymentAmount / 1000;
    }
}