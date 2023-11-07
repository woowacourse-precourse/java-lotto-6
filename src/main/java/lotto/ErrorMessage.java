package lotto;

public class ErrorMessage {

    public static final String COMMON = "[ERROR]";
    public static final String REQUIRED_VALUE = COMMON + "필수로 입력해야 합니다.";
    public static final String IS_NOT_NUMBER = COMMON + "숫자를 입력해주세요.";
    public static final String PURCHASE_AMOUNT_UNIT = COMMON + "로또 구입 금액은 1,000원 단위여야 합니다.";
    public static final String PURCHASE_AMOUNT_ZERO = COMMON + "로또 구입 금액은 0원일 수 없습니다.";
    public static final String NULL = COMMON + "입력 값이 null일 수 없습니다.";
    public static final String DUPLICATED_LOTTO = COMMON + "로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_NUMBER_RANGE =
            COMMON + "로또 번호의 숫자 범위는 " + LottoNumbers.START_LOTTO_NUMBER + " 이상 "
                    + LottoNumbers.END_LOTT0_NUMBER + " 이하의 수 입니다.";
    public static final String WINNING_NUMBER_FORMAT = COMMON + "입력 값은 숫자와 쉼표만 올 수 있습니다.";
}
