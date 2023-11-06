package lotto.util;

public class ErrorMessage {
    public static final String MONEY_CONVERT_ERROR="[ERROR] 구매 금액은 1000원 단위의 숫자를 입력해 주세요. ex) 5000";

    public static final String LOTTO_STRING_ERROR = "[ERROR] 로또 번호에 문자열이 들어올 수 없습니다.";
    public static final String LOTTO_SIZE_ERROR="[ERROR] 로또 번호는 총 6자리여야 합니다.";
    public static final String LOTTO_RANGE_ERROR="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_UNIQUE_ERROR="[ERROR] 로또 번호 간 중복이 있습니다.";

    public static final String LOTTO_BONUS_STRING_ERROR="[ERROR] 보너스 번호에 문자열이 들어올 수 없습니다.";
    public static final String LOTTO_BONUS_UNIQUE_ERROR="[ERROR] 보너스 번호는 당첨번호와 중복 될 수 없습니다.";
    public static final String LOTTO_BONUS_RANGE_ERROR="[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
}
