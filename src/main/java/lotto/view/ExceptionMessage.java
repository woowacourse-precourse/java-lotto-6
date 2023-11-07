package lotto.view;

public class ExceptionMessage {

    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_DIVIDE_ERROR = "[ERROR] 금액 1000으로 나누어떨어져야 합니다.";

    public static void numberException() {
        System.out.println(NOT_NUMBER_ERROR);
    }

    public static void numberNotDivideException() {
        System.out.println(NOT_DIVIDE_ERROR);
    }
}
