package lotto.View;

public class ExceptionMessages {

    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호를 입력했습니다.";
    private static final String LOTTO_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개 입니다.";
    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.";
    private final static String BONUS_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자입니다. 숫자로 이루어진 값을 입력해주세요";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final static String PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE = "[ERROR] 숫자로 이루어진 값을 입력해주세요";
    private final static String PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE = "[ERROR] 1000원 이상의 1000원 단위의 올바른 금액을 입력해주세요";

    public static void lottoNumberRangeError() {
        System.out.println(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    public static void lottoNumberDuplicateError() {
        System.out.println(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    public static void lottoNumberTypeError() {
        System.out.println(LOTTO_NUMBER_TYPE_ERROR_MESSAGE);
    }

    public static void lottoNumberCountError() {
        System.out.println(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
    }

    public static void bonusNumberDuplicateError() {
        System.out.println(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    public static void bonusNumberTypeError() {
        System.out.println(BONUS_NUMBER_TYPE_ERROR_MESSAGE);
    }

    public static void bonusNumberRangeError() {
        System.out.println(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
    }

    public static void purchaseAmountTypeError() {
        System.out.println(PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE);
    }

    public static void purchaseAmountRangeError() {
        System.out.println(PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE);
    }

}
