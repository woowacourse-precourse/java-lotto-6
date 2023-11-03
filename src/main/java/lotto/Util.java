package lotto;

public class Util {
    public static int paymentToInteger(String payment) {
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages
                    .NON_NUMERIC_INPUT
                    .getMessage());
        }
    }
}
