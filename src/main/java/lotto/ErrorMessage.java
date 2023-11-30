package lotto;

public class ErrorMessage {
    //INT
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_MIN_PRICE = 1000;
    //STRING
    private static final String NOT_NUMBER_RANGE = "[ERROR] 숫자는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 까지의 숫자여야 합니다.";
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개만 입력 가능합니다.";
    private static final String NOT_NUMBER_AGAIN = "[ERROR] 중복된 숫자입니다.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 입력값은 숫자만 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_UPZERO_NUMBER_ERROR = "[ERROR] 금액은 0 초과여야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + LOTTO_MIN_PRICE + "원 단위여야 합니다.";

    public static void rangeException() {
        System.out.println(NOT_NUMBER_RANGE);
    }

    public static void sizeException() {
        System.out.println(NOT_NUMBER_SIZE);
    }

    public static void overlapException() {
        System.out.println(NOT_NUMBER_AGAIN);
    }

    public static void typeException() {
        System.out.println(INPUT_TYPE_ERROR);
    }

    public static void numberException() {
        System.out.println(NOT_NUMBER_ERROR);
    }

    public static void naturalException() {
        System.out.println(NOT_UPZERO_NUMBER_ERROR);
    }

    public static void divisibleException() {
        System.out.println(NOT_DIVISIBLE_NUMBER_ERROR);
    }
}
