package lotto.view;

public class ErrorMessage {

    public static final String EMPTY = "[ERROR] 입력 값이 없습니다.";
    public static final String ONLY_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    public static final String VALUE_EXISTS = "[ERROR] 입력되지 않은 번호가 있습니다.";
    public static final String ONLY_NUMBER_ADN_COMMA = "[ERROR] 공백 없이 쉼표(,)로 구분된 숫자로만 입력해주세요.";
    public static final String PURCHASE_MIN = "[ERROR] 로또를 한 장 이상 구매해야 합니다. (로또 1장 1,000원)";
    public static final String PURCHASE_UNITS = "[ERROR] 로또는 1,000원 단위로 구매 가능합니다. (로또 1장 1,000원)";
    public static final String LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호는 6개 여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static final String LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String WINING_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 여야 합니다.";
    public static final String WINING_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다.";
    public static final String WINING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
}
