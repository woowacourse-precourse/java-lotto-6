package lotto.View;

public class ExceptionView {
    private static final String NUMBER_SIZE_ERROR = "[ERROR] 6개 입력";
    private static final String NUMVER_OUVERLAP = "[ERROR] 중복된 숫자 입력";
    private static final String INPUT_TYPE_ERROR = "[ERROR]";
    private static final int MIN_AMOUNT = 1000;
    private static final String DIVISIBLE_NUMBER_ERROR = "[ERROR] " + MIN_AMOUNT + "단위만 입력";

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
}
