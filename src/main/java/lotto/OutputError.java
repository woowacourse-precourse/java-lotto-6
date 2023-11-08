package lotto;

public class OutputError {
    private static final String ERROR = "[ERROR] ";
    private static final String ERROR_INDIVISIBLE = "금액은 1000원 단위로 입력해 주세요.";
    private static final String ERROR_NOT_NUMBER = "1과 45 사이의 숫자를 입력해 주세요";
    private static final String ERROR_Duplication = "중복 되지 않은 값을 입력해 주세요.";

    public static void error_not_number() {
        System.out.println(ERROR + ERROR_NOT_NUMBER);
    }

    public static void error_indivisible() {
        System.out.println(ERROR + ERROR_INDIVISIBLE);
    }
    public static void error_duplication() {
        System.out.println(ERROR + ERROR_INDIVISIBLE);
    }

}
