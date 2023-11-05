package lotto.io;

public class IOOperation {
    private static final Integer unit = 1000;

    public static Boolean isPriceCorrect(Integer price) {
        if (price % unit != 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
