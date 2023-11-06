package lotto.exception;

public class ExceptionMessage {
    private static final String NUMBER_ALREADY_EXIST = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력해주세요.";
    private static final String EXCEEDED_NUMBER = "[ERROR] 숫자는 6개만 입력 가능합니다.";

    public static void existException() {
        System.out.println(NUMBER_ALREADY_EXIST);
    }

    public static void typeException() {
        System.out.println(INPUT_TYPE_ERROR);
    }

    public static void sizeException() {
        System.out.println(EXCEEDED_NUMBER);
    }
}
