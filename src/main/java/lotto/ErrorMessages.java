package lotto;

public class ErrorMessages {
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String INVALID_LOTTO_SIZE = ERROR_MESSAGE_PREFIX + "로또 번호는 6개를 입력해야 합니다.";
    public static final String INVALID_LOTTO_RANGE = ERROR_MESSAGE_PREFIX + "로또 번호는 1부터 45 사이의 숫자입니다.";
    public static final String LOTTO_NUMBER_DUPLICATION = ERROR_MESSAGE_PREFIX + "로또 번호는 중복된 숫자가 존재할 수 없습니다.";
    public static final String INVALID_BONUS_RANGE = ERROR_MESSAGE_PREFIX + "보너스 번호는 1부터 45 사이의 숫자입니다.";
    public static final String INVALID_INPUT_FORMAT = ERROR_MESSAGE_PREFIX + "입력값은 정수여야 합니다.";
    public static final String INVALID_PURCHASE_SIGN = ERROR_MESSAGE_PREFIX + "구매 금액은 양수여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_UNIT = ERROR_MESSAGE_PREFIX + "구매 금액은 1000으로 나누어 떨어지는 수여야 합니다.";
}
