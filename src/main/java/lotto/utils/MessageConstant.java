package lotto.utils;

public final class MessageConstant {
    // Input Message
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    // Output Message
    public static final String LOTTO_COUNT = "%d개를 구매했습니다.";
    public static final String RESULT = "당첨 통계" + "\n" + "---";
    public static final String COUNT = "%d개";
    public static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    // Error Message
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_NUMBER = "올바른 숫자를 입력해 주세요. (최대 입력은 2,147,483,647)";
    public static final String LOTTO_SIZE = "6개의 숫자를 입력해 주세요.";
    public static final String NUMBER_SIZE = "1개의 숫자를 입력해 주세요.";
    public static final String DUPLICATION = "중복된 숫자가 존재합니다.";
    public static final String LOTTO_OUT_OF_RANGE = "1~45 사이의 숫자를 입력해 주세요.";
    public static final String MONEY_OUT_OF_RANGE = "1000원 단위의 금액을 입력해 주세요.";

    private MessageConstant() {
    }
}
