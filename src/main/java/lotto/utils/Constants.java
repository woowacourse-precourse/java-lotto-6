package lotto.utils;

public class Constants {
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final int LOTTO_NUM_MIN = 1;
    public static final int LOTTO_NUM_MAX = 45;
    public static final int LOTTO_NUM_COUNT = 6;

    public static final String ERROR = "[ERROR] ";
    public static final String NOT_POSITIVE_INTEGER_MSG = ERROR + "구입금액은 양수로 입력해야 합니다.";
    public static final String NOT_DIVISIBLE_MSG = ERROR + "구입금액이 로또 가격인 1000원으로 나누어 떨어져야 합니다.";

}
