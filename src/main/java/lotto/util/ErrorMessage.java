package lotto.util;

public class ErrorMessage { //에러 유형별 메시지 상수 보관

    public static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    public static final String ERROR_MESSAGE_NUMBER_OF_LOTTO_ISNT_SIX = "번호가 6개가 아닙니다.";
    public static final String ERROR_MESSAGE_LOTTO_CANT_BE_DUPLICATED = "번호는 중복될 수 없습니다.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBER_OUT_OF_RANGE = "로또 번호는 1~45 사이여야 합니다.";
    public static final String ERROR_MESSAGE_EMPTY_INPUT = "입력 값이 비어 있습니다.";
    public static final String ERROR_MESSAGE_ONLY_COMMA = "쉼표(,)만 입력되었습니다.";
    public static final String ERROR_MESSAGE_NOT_ONLY_NUMBER = "숫자 외의 다른 문자가 입력되었습니다.";
    public static final String ERROR_MESSAGE_PURCHASE_AMOUNT_CANT_DIVIDE_BY_THOUSAND = "1000으로 나누어 지지 않는 숫자입니다.";
    public static final String ERROR_MESSAGE_PURCHASE_AMOUNT_CANT_BE_ZERO = "구입 금액은 0이 될 수 없습니다.";

}
