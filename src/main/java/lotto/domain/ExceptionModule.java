package lotto.domain;

public class ExceptionModule {

    public static Integer checkParseIntException(String consoleRead) throws IllegalArgumentException{
        try {
            return Integer.parseInt(consoleRead);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkThousandException(Integer tryNum, Integer LOTTO_PRICE) throws IllegalArgumentException{
        if (tryNum % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
