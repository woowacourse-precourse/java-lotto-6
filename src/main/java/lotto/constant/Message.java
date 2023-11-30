package lotto.constant;

public final class Message {

    public static final String COMMA = ",";
    public static final String PURCHASE_MONEY = "구입금액";
    public static final String WINNING_NUMBERS = "당첨 번호";

    public static final String BONUS_NUMBER = "보너스 번호";
    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String ERROR_TEMPLATE = "[ERROR] %s\n";
    public static final String ERROR_NOT_A_NUMBER = "(은)는 0 이상 2147483647이하의 숫자여야 합니다.";

    public static final String ERROR_NOT_IN_THOUSANDS = "(은)는 1000원 단위여야 합니다.";
    public static final String ERROR_MONEY_CAN_NOT_BE_ZERO = "(은)는 0 이상의 숫자여야 합니다.";
    public static final String ERROR_NUMBER_OUT_OF_RANGE = "(은)는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_NOT_SIX_WINNING_NUMBERS = "(은)는 6자리 숫자여야 합니다.";
    public static final String ERROR_NOT_ONE_NUMBER = "(은)는 1자리 숫자여야 합니다.";
    public static final String ERROR_DUPLICATED_NUMBER = "(은)는 중복될 수 없습니다.";

    public static final String ALL_PASS = "모든 단계 통과";
    public static final String PURCHASED_LOTTO = "%d개를 구매했습니다.";
    public static final String RESULT_MESSAGE =
            """
                    당첨통계
                    ---
                    """;

    public static final String INTEREST_RATE_MESSAGE = "총 수익률은 %s입니다.";

    public static final String FIFTH_PRIZE = "3개 일치 ";
    public static final String FOURTH_PRIZE = "4개 일치 ";
    public static final String THIRD_PRIZE = "5개 일치 ";
    public static final String SECOND_PRIZE = "5개 일치, 보너스 볼 일치 ";
    public static final String FIRST_PRIZE = "6개 일치 ";

}
