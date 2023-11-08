package lotto.constant;

public class ErrorConstant {
    public static final String ERROR_BONUS_NUMBER_NOT_INTEGER = "[ERROR] 보너스 번호는 정수만 입력 가능합니다.";
    public static final String ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 로또 번호와 중복된 숫자는 입력할 수 없습니다.";
    public static final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1 ~ 45 사이만 입력 가능합니다.";

    public static final String ERROR_WINNING_NUMBER_DUPLICATE = "[ERROR] 중복된 숫자가 포함 되었습니다.";
    public static final String ERROR_WINNING_NUMBER_RANGE= "[ERROR] 로또 범위는 1 ~ 45 입니다.";
    public static final String ERROR_WINNING_NUMBER_SIZE = "[ERROR] 로또 번호는 6개 입니다.";

    public static final String ERROR_PAYMENT_NOT_INTEGER = "[ERROR] 금액 가격에는 정수만 입력 가능합니다.";
    public static final String ERROR_PAYMENT_PURCHASE_UNIT = "[ERROR] 로또는 1000원 단위로만 구매할 수 있습니다.";

}
