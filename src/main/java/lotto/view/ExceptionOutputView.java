package lotto.view;

public class ExceptionOutputView {
    private static final String EXCEPTION_PRINT_FORMAT = "[ERROR] %s\n";

    private static final String LOTTO_DUPLICATE_ERROR = "로또 번호는 중복될 수 없습니다.";
    private static final String LOTTO_SIX_DIGIT_ERROR = "로또 번호는 6개를 가져야 합니다.";
    private static final String LOTTO_RANGE_ERROR = "로또 번호의 범위는 1~45입니다.";
    private static final String INPUT_NOT_INTEGER_ERROR = "해당 입력은 정수가 아닙니다.";
    private static final String MONEY_RANGE_ERROR = "구입금액은 1000원 단위입니다.";
    private static final String LOTTO_STRING_FORMAT_ERROR = "로또 형식에 맞지 않은 입력입니다.";
    private static final String BONUS_RANGE_ERROR = "보너스 번호 범위에 맞지 않은 입력입니다.";

    public static void printLottoDuplicateError() {
        System.out.printf(EXCEPTION_PRINT_FORMAT, LOTTO_DUPLICATE_ERROR);
    }

    public static void printLottoSixDigitError() {
        System.out.printf(EXCEPTION_PRINT_FORMAT, LOTTO_SIX_DIGIT_ERROR);
    }

    public static void printLottoRangeError() {
        System.out.printf(EXCEPTION_PRINT_FORMAT, LOTTO_RANGE_ERROR);
    }


    public static void printInputIntegerError() {
        System.out.printf(EXCEPTION_PRINT_FORMAT, INPUT_NOT_INTEGER_ERROR);
    }

    public static void printMoneyRangeError() {
        System.out.printf(EXCEPTION_PRINT_FORMAT, MONEY_RANGE_ERROR);
    }

    public static void printLottoStringFormatError() {
        System.out.printf(EXCEPTION_PRINT_FORMAT, LOTTO_STRING_FORMAT_ERROR);
    }

    public static void printBonusRangeError() {
        System.out.printf(EXCEPTION_PRINT_FORMAT, BONUS_RANGE_ERROR);
    }


}
