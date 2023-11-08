package lotto.utils;

public class Constants {
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final int LOTTO_NUM_MIN = 1;
    public static final int LOTTO_NUM_MAX = 45;
    public static final int LOTTO_NUM_COUNT = 6;

    public static final String ERROR = "[ERROR] ";
    public static final String NOT_POSITIVE_INTEGER_MSG = ERROR + "구입금액은 양수로 입력해야 합니다.";
    public static final String NOT_DIVISIBLE_MSG = ERROR + "구입금액이 로또 가격인 1000원으로 나누어 떨어져야 합니다.";
    public static final String EMPTY_INPUT_MSG = ERROR + "당첨 번호를 입력해주세요.";
    public static final String MISSING_COMMA_MSG = ERROR + "당첨 번호는 쉼표(,)로 구분하여 입력해주세요.";
    public static final String INVALID_NUM_COUNT_MSG = ERROR + "당첨 번호는 6개를 입력해야 합니다.";
    public static final String INVALID_NUM_RANGE_MSG = ERROR + "당첨 번호는 1부터 45까지의 정수를 쉼표를 띄우지 않고 입력해야 합니다.";
    public static final String DUPLICATE_NUM_MSG = ERROR + "중복된 번호가 있습니다. 각 번호는 서로 다른 숫자여야 합니다.";
    public static final String INVALID_BONUS_NUMBER_MSG = ERROR + "보너스 번호는 1부터 45 사이의 정수여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER_MSG = ERROR + "보너스 번호가 당첨 번호와 중복됩니다.";

}
