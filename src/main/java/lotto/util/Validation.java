package lotto.util;

public class Validation {
    public static void purchaseAmount(int amount) {
        if ((amount % 1000) > 0) {
            throw new IllegalArgumentException();
        }
    }
}
