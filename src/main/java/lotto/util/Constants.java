package lotto.util;

public final class Constants {

    public static final int TICKET_PRICE = 1000;
    public static final int MIN_PRICE = 0;
    public static final int MAX_PRICE = 2_000_000_000;
    public static final String ERROR_INTEGER_TYPE_ERROR = "[ERROR] 숫자가 입력되어야 합니다.";
    public static final String ERROR_LOTTO_BUDGET_RANGE = "[ERROR] 구입금액은 0원 이상 MAX 이하여야 합니다";
    public static final String ERROR_LOTTO_BUDGET_PRICE = "[ERROR] 구입금액은 1000원 단위여야 합니다. ";
    public static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_LOTTO_DUPLICATE_NUMBER = "[ERROR] 로또 번호가 중복됩니다.";
    public static final String ERROR_LOTTO_INVALID_SIZE = "[ERROR] 로또 번호가 6개가 아닙니다.";
    public static final int LOTTO_NUMBER_START_RANGE = 1;
    public static final int LOTTO_NUMBER_END_RANGE = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
}
