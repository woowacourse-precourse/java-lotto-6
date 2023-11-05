package lotto.view;

public class ExceptionMessage {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + LOTTO_MIN_AMOUNT + "단위여야 합니다.";
    public static void numberFormatException() {
        System.out.println(INPUT_TYPE_ERROR);
    }
    public static void numberException() {
        System.out.println(NOT_NUMBER_ERROR);
    }

    public static void naturalException() {
        System.out.println(NOT_NATURAL_NUMBER_ERROR);
    }

    public static void divisibleException() {
        System.out.println(NOT_DIVISIBLE_NUMBER_ERROR);
    }
}
