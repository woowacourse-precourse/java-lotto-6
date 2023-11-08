package lotto.data;

public class Messages {
    public static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    public static final String ASK_WINNIG_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String ERROR_PREFIX = "[ERROR] : ";
    public static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String SPLIT_STRING = ",";
    public static final String TICKET_PRINT_FORMAT = "%d개를 구매했습니다.\n";
    public static final String DECIMAL_FORMAT = "#,###.0";
    public static final String INPUT_ERROR_MESSAGE = "wrong money input";
    public static final String OVERFLOW_ERROR_MESSAGE = "overflow";
    public static final String LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 6개 이어야 합니다.";
    public static final String LOTTO_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복 되어서는 안됩니다.";
    public static final String LOTTO_RANGE_ERROR_MESSAGE = "로또 1부터 45까지 입니다.";
    public static final String LOTTO_TICKETS_COUNT_ERROR_MESSAGE = "로또는 100장만 살 수 있습니다.";


    public static String printRateMessage(String rate) {
        return "총 수익률은 " + rate + "%입니다.";
    }
}
