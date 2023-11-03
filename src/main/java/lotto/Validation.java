package lotto;

public class Validation {
    public static void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
