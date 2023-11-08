package lotto.utils;

public class ErrorMessages {
    private static final String PREFIX = "[ERROR] ";
    public static final String NOT_INTEGER_INPUT = PREFIX + "입력이 정수가 아닙니다.";
    public static final String CHANGE_REMAINING = PREFIX + "구입 금액이 로또 가격으로 나누어 떨어지지 않아 잔돈이 발생합니다.";
    public static final String PURCHASE_AMOUNT_LESS_THAN_OR_EQUAL_TO_ZERO =
            PREFIX + "구입 금액은 0보다 작거나 같을 수 없습니다.";
    public static final String TOO_MUCH_PURCHASE_AMOUNT =
            PREFIX + "구입 금액이 너무 큽니다. 최대로 구입 가능한 로또 개수는 %d개 입니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE = PREFIX + "로또 번호는 %d~%d사이의 숫자여야 합니다.";
    public static final String INVALID_LOTTO_NUMBERS_LENGTH = PREFIX + "로또는 총 %d개의 번호로 이루어져야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATION = PREFIX + "로또 번호에 중복이 있습니다.";
    public static final String WINNING_NUMBERS_CONTAINS_BONUS_NUMBER = PREFIX + "보너스 번호가 당첨 번호와 중복됩니다.";
}
