package lotto.validator.ErrorMessage;

public class ErrorMessage {
    public static final String EMPTY_INPUT_EXCEPTION_MESSAGE = "[ERROR] 아무 값도 입력하지 않았습니다.";
    public static final String NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 숫자를 입력해야 합니다.";
    public static final String NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.";
    public static final String NOT_IN_RIGHT_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NOT_RIGHT_AMOUNT_OF_WINNING_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    public static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 중복되지 않은 숫자를 입력해야 합니다.";
    public static final String WINNING_LOTTO_CONTAINS_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호에 보너스 번호가 포함되었습니다.";

}
