package lotto;

public class Util {
    private static final int lottoAmount = 1000;

    public static int getLottoCount(int totalAmount) {
        return totalAmount / lottoAmount;
    }
}
