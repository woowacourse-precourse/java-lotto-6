package lotto.constant;

public final class Message {

    public static final String PURCHASE_MONEY = "구입금액";
    public static final String WINNING_NUMBERS = "당첨 번호";

    public static final String BONUS_NUMBER = "보너스 번호";
    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String ERROR_TEMPLATE = "[ERROR] %s\n";
    public static final String ERROR_MSG_NOT_A_NUMBER = "(은)는 숫자여야 합니다.";

    public static final String ERROR_MSG_NOT_IN_THOUSANDS = "(은)는 1000원 단위여야 합니다.";
    public static final String ERROR_MSG_OUT_OF_RANGE = "(은)는 1부터 45 사이의 수여야 합니다.";
    public static final String ERROR_MSG_LENGTH_NOT_MATCH = "(은)는 6자리여야 합니다.";
    public static final String ERROR_MSG_DUPLICATED_NUMBER = "(은)는 중복될 수 없습니다.";

    public static final String RESULT_MESSAGE =
            """
            당첨통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개\n
            """;

    public static final String INTEREST_RATE_MESSAGE = "총 수익률은 %s입니다.\n";


}
