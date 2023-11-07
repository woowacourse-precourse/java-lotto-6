package lotto.util;

public class InputDataException {
    public static void validatePaymentInput(String payment) {
        if(!payment.matches("\\d+")) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_PAYMENT_INPUT);
        }
    }
}
