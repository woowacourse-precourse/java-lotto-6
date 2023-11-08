package lotto;

public class ExceptionMessage {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_COUNT = 6;

    private static final String NOT_INTEGER = "숫자만 입력 가능합니다.";
    private static final String NOT_MULTIPLE_OF_PRICE = "구입금액은 " + LOTTO_PRICE + "의 배수여야 합니다.";
    private static final String OUT_OF_RANGE = "당첨 번호는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + " 사이의 숫자여야 합니다.";
    private static final String NOT_LOTTO_COUNT = "당첨 번호는 " + LOTTO_COUNT + "개의 숫자를 입력해야 합니다.";
    private static final String LOTTO_DUPLICATED = "당첨 번호는 서로 중복되지 않아야 합니다.";
    private static final String BONUS_DUPLICATED = "당첨 번호와 보너스 번호는 서로 중복되지 않아야 합니다.";

    public static String notInteger() {
        return NOT_INTEGER;
    }

    public static String notMultipleOfPrice() {
        return NOT_MULTIPLE_OF_PRICE;
    }

    public static String outOfRange() {
        return OUT_OF_RANGE;
    }

    public static String notLottoCount() {
        return NOT_LOTTO_COUNT;
    }

    public static String lottoDuplicated() {
        return LOTTO_DUPLICATED;
    }

    public static String bonusDuplicated() {
        return BONUS_DUPLICATED;
    }
}
