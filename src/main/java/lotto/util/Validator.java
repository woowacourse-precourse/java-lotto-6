package lotto.util;

public class Validator {

    public static void purchasePrice(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
