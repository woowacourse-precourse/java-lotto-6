package lotto;

public class ErrorMessage {

    private static final String ERROR_FLAG = "[ERROR]";
    private static final String ERROR_NUMBER = "금액은 숫자만 입력 가능합니다.";
    private static final String ERROR_PRICE = "금액은 " + CommonLotto.LOTTO_PRICE + " 단위여야 합니다.";
    private static final String ERROR_NUM_COUNT = "당첨 번호는 " + CommonLotto.LOTTO_COUNT + "개 입력해야 합니다.";
    private static final String ERROR_NUM_RANGE = "숫자는 1 부터 45까지 입니다.";
    private static final String ERROR_NUM_REDUNDANT = "중복되는 숫자를 입력하셨습니다.";

    public static void numberExcept() {
        System.out.println(ERROR_FLAG + ERROR_NUMBER);
    }

    public static void priceExcept() {
        System.out.println(ERROR_FLAG + ERROR_PRICE);
    }

    public static void numCountExcept() {
        System.out.println(ERROR_FLAG + ERROR_NUM_COUNT);
    }

    public static void numRangeExcept() {
        System.out.println(ERROR_FLAG + ERROR_NUM_RANGE);
    }

    public static void redundantExcept() {
        System.out.println(ERROR_FLAG + ERROR_NUM_REDUNDANT);
    }

}
