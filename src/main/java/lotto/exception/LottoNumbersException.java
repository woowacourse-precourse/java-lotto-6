package lotto.exception;

public class LottoNumbersException {

    public static void lottoSizeException() {
        throw new IllegalArgumentException();
    }

    public static void lottoNumException() {
        throw new IllegalArgumentException();
    }

    public static void lottoDupException() {
        throw new IllegalArgumentException();
    }

    public static void lottoZeroException() {
        throw new IllegalArgumentException();
    }

}
