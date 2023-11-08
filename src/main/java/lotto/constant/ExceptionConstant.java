package lotto.constant;

public class ExceptionConstant {
    public static final String NUMBER_FORMAT_PATTERN = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
    public static final String FORMAT_ERROR_MESSAGE = "[ERROR] 로또 번호는 '1,2,3,4,5,6'과 같은 형식으로 입력해야 합니다.";
    public static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String BOUNDARY_ERROR_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.";

    public static final String NUMERIC_PATTERN = "\\d+";
    public static final String PURCHASE_NUMERIC_ERROR_MESSAGE = "[ERROR] 구입금액이 유효하지 않습니다.";
    public static final int LOTTO_TICKET_PRICE_UNIT = 1000;
    public static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입금액은 1,000단위이어야 합니다.";

    public static final String BONUS_NUMBER_PATTERN = "^([1-9]|[1-3]\\d|4[0-5])$";
    public static final String BONUS_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.";
}
