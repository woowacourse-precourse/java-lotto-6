package lotto.system;

public final class ExceptionMessage {

    private ExceptionMessage() {
    }

    public static final String OUT_OF_RANGE = "[ERROR] 로또 구입 금액이 유효한 값 범위를 벗어났습니다.";
    public static final String IS_NOT_NUMERIC = "[ERROR] 입력된 값은 숫자가 아닙니다.";
    public static final String IS_NOT_POSITIVE = "[ERROR] 로또 구입 금액이 양수가 아닙니다.";
    public static final String IS_NOT_DIVISIBLE = "[ERROR] 로또 구입 금액이 " + Constant.MONEY_UNIT + "원으로 나누어 떨어지지 않습니다.";

    public static final String EACH_NOT_NUMERIC = "[ERROR] 입력된 값은 숫자가 아닙니다.";
    public static final String COUNT_NOT_EQUAL = "[ERROR] 입력된 당첨번호는 " + Constant.LOTTO_SIZE + "개의 숫자가 아닙니다.";
    public static final String NUMBER_EACH_OUT_OF_RANGE = "[ERROR] 입력된 번호는 " + Constant.START_INCLUSIVE + "부터 " + Constant.END_INCLUSIVE + " 사이의 숫자이어야 합니다.";

    public static final String NUMBER_NOT_DISTINCT = "[ERROR] 중복된 로또 번호입니다.";

    public static final String NUMBER_OUT_OF_TYPE_RANGE = "[ERROR] 입력된 숫자는 정상적인 범위의 값이 아닙니다.";
    public static final String BONUS_NUMBER_EXISTS_IN_WINNING_LOTTO = "[ERROR] 입력된 보너스 넘버는 당첨번호에 이미 존재합니다.";


}
