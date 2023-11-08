package lotto.message;

public class ErrorMessage {
    public static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String SIX_DIGITS_EXCEPTION_MESSAGE = "[ERROR] 6자리의 로또 번호를 입력하세요.";
    public static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 중복되면 안됩니다.";

    public static final String INSUFFICIENT_FUNDS_EXCEPTION_MESSAGE = "[ERROR] 금액이 부족하여 로또를 살 수 없습니다.";
    public static final String COMMA_BASED_EXCEPTION_MESSAGE = "[ERROR] (,)를 기준으로 입력해주세요.";
    public static final String NUMBER_INPUT_EXCEPTION_MESSAGE = "[ERROR] 입력 번호는 숫자로 이루어져야 합니다.";
    public static final String BONUS_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.";
}
