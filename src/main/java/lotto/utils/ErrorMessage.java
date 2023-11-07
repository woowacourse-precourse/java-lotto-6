package lotto.utils;

public class ErrorMessage {
    private static final String NOT_A_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    public static void numberException() {
        System.out.println(NOT_A_NUMBER);
    }
}
