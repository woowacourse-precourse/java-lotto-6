package lotto.constant.message;

public class ErrorMessage {
    public static final String IS_NOT_INTEGER = "[ERROR] 정수 형태의 숫자로 입력하세요.";
    public static final String IS_UNDER_THOUSAND = "[ERROR] 로또는 1,000원 이상부터 구매 가능합니다.";
    public static final String CAN_NOT_DIVIDE_BY_THOUSAND = "[ERROR] 로또는 1,000원 단위로 구매 가능합니다.";
    public static final String IS_NOT_LENGTH_SIX = "[ERROR] 로또 번호는 6개가 되어야 합니다.";
    public static final String IS_NOT_DISTINCT = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String IS_NOT_IN_RANGE = "[ERROR] 로또 번호는 1부터 45까지입니다.";
    public static final String IS_NOT_INPUT_FORMAT = "[ERROR] 입력 포맷을 지켜 입력하세요. (ex: 1,2,3,4,5,6)";
}
