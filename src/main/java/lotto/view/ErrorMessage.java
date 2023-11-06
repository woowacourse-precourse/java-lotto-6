package lotto.view;

public class ErrorMessage {
    private static final String NOT_INTEGER = "[ERROR] 숫자를 입력해주세요.";
    private static final String OUT_OF_INTEGER_RANGE = "[ERROR] 정수 입력 범위를 초과했습니다.";

    public void notifyIsNotInteger() {
        System.out.println(NOT_INTEGER);
    }

    public void notifyIsOutOfIntegerRange() {
        System.out.println(OUT_OF_INTEGER_RANGE);
    }
}
