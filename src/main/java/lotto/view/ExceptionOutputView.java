package lotto.view;

public class ExceptionOutputView {

    private static final String LOTTO_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String LOTTO_SIX_DIGIT_ERROR = "[ERROR] 로또 번호는 6개를 가져야 합니다.";
    private static final String LOTTO_RANGE_ERROR = "[ERROR] 로또 번호의 범위는 1~45입니다.";
    public static final String MONEY_RANGE_ERROR = "[ERROR] 구입금액은 1000원 단위 정수 입니다.";
    public static final String LOTTO_STRING_FORMAT_ERROR = "[ERROR] 로또 형식에 맞지 않은 입력입니다.";
    public static final String BONUS_RANGE_ERROR = "[ERROR] 보너스 번호는 1~45 사이 정수 입니다.";

    public static void printLottoDuplicateError() {
        System.out.println(LOTTO_DUPLICATE_ERROR);
    }

    public static void printLottoSixDigitError() {
        System.out.println(LOTTO_SIX_DIGIT_ERROR);
    }

    public static void printLottoRangeError() {
        System.out.println(LOTTO_RANGE_ERROR);
    }
}
