package lotto.exception;

public class WinningNumException {

    private static final String SIZE_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다.";
    private static final String INT_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 숫자가 아닌 문자를 입력해서는 안됩니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자를 입력해야 합니다.";

    public static void winningSizeException() {
        throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
    }

    public static void winningIntException() {
        throw new IllegalArgumentException(INT_EXCEPTION_MESSAGE);
    }

    public static void winningRangeException() {
        throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
    }

}
