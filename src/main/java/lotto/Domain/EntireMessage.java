package lotto.Domain;

public class EntireMessage {
    //EntireMessage
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String COUNT_SUFFIX = "개";
    public static final String WINNING_STATISTICS_MSG = "당첨 통계";
    public static final String DASH = "---";
    public static final String STATISTICS_PREFIX_MSG = "총 수익률은 ";
    public static final String STATISTICS_SUFFIX_MSG = "%입니다.";

    //InputView
    public static final String START_GAME_MSG = "구입금액을 입력해 주세요. ";
    public static final String WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요: ";
    public static final String INPUT_ERROR_MSG_BASIC = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INPUT_ERROR_MSG_BONUS = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INPUT_ERROR_MSG_FORMAT = "올바른 숫자를 입력해 주세요.";

    //InputView & Lotto
    public static final String ERROR_MSG_LENGTH = "로또 번호는 6개여야 합니다.";
    public static final String ERROR_MSG_DUPLICATED = "로또 번호에 중복된 숫자가 있습니다.";

    //OutputView
    public static final String PURCHASED_MSG_PREFIX = "원으로 ";
    public static final String PURCHASED_MSG_SUFFIX = "개를 구매했습니다.";

    public static void displayError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}