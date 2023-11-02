package lotto.View;

public class ExceptionView {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NUMBER_RANGE_ERROR = "[ERROR]" + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이 숫자 입력.";
    private static final String NUMBER_SIZE_ERROR = "[ERROR] 6개 입력";
    private static final String NUMVER_OUVERLAP = "[ERROR] 중복된 숫자 입력";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력";
    private static final int MIN_AMOUNT = 1000;
    private static final String DIVISIBLE_NUMBER_ERROR = "[ERROR] " + MIN_AMOUNT + "단위만 입력";
    private static final String NUMBER_ERROR = "[ERROR] 숫자만 입력 가능";
    private static final String NATURAL_NUMBER_ERROR = "[ERROR] 0 초과 입력";

    public static void rangeException() {
        System.out.println(NUMBER_RANGE_ERROR);
    }
    public static void sizeException() {
        System.out.println(NUMBER_SIZE_ERROR);
    }
    public static void overlapException() {
        System.out.println(NUMVER_OUVERLAP);
    }
    public static void typeException() {
        System.out.println(INPUT_TYPE_ERROR);
    }
    public static void divisibleException() {
        System.out.println(DIVISIBLE_NUMBER_ERROR);
    }
    public static void numberException() {
        System.out.println(NUMBER_ERROR);
    }
    public static void naturalException() {
        System.out.println(NATURAL_NUMBER_ERROR);
    }
}
