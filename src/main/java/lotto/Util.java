package lotto;

public class Util {

    private static final int LOTTO_PRICE = 1000;

    public int getLottoCnt(String amount) {
        return (Integer.parseInt(amount) / LOTTO_PRICE);
    }
}
