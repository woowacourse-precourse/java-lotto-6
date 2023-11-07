package lotto.util.message;

public class ErrorMessages {
    public static final String NUMBER_FORMAT_EXCEPTION = "[ERROR] 정수만 입력 가능합니다.";
    public static final String BLANK_EXCEPTION = "[ERROR] 공백 문자는 입력할 수 없습니다.";
    public static final String USER_MONEY_UNIT_EXCEPTION = "[ERROR] 구입 금액은 1000원 단위입니다.";
    public static final String LOTTO_LENGTH_EXCEPTION = "[ERROR] 로또 번호의 개수는 6개만 가능합니다.";
    public static final String LOTTO_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_DUPLICATION_EXCEPTION = "[ERROR] 로또 번호 중 중복된 숫자가 존재합니다.";
    public static final String BONUS_RANGE_EXCEPTION = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_DUPLICATION_EXCEPTION = "[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.";
}
