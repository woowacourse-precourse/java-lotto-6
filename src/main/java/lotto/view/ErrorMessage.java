package lotto.view;

public class ErrorMessage {
    private static final String ERROR = "[ERROR] ";
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String CHECK_RANGE = MIN_NUM + "부터 " + MAX_NUM + "까지 입력가능합니다.";
    private static final String CHECK_COUNT = "6개 입력 가능합니다.";
    private static final String CHECK_DUPLICATE = "중복된 숫자 입력했습니다.";
    private static final String CHECK_NUMBER = "숫자만 입력 가능합니다";
    private static final int MIN_LOTTO = 1000;
    private static final String CHECK_LOTTO_PRICE = MIN_LOTTO + "이상부터 입력가능합니다.";
    private static final String CHECK_LOTTO_DIVIDE = MIN_LOTTO + "단위로 입력가능합니다.";

    public static void range_Error() {
        System.out.println(ERROR + CHECK_RANGE);
    }

    public static void count_Error() {
        System.out.println(ERROR + CHECK_COUNT);
    }

    public static void duplicate_Error() {
        System.out.println(ERROR + CHECK_DUPLICATE);
    }

    public static void number_Error() {
        System.out.println(ERROR + CHECK_NUMBER);
    }

    public static void lotto_price_Error() {
        System.out.println(ERROR + CHECK_LOTTO_PRICE);
    }

    public static void lotto_divide_Error() {
        System.out.println(ERROR + CHECK_LOTTO_DIVIDE);
    }
}
