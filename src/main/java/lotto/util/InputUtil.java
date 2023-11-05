package lotto.util;

public class InputUtil {
    private InputUtil() {
    }

    public static int preprocessLottoPurchasePrice(String lottoPurchasePrice) {
        return parseInt(lottoPurchasePrice);
    }

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }

}
