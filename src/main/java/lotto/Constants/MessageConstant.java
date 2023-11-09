package lotto.Constants;

public class MessageConstant {

    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요";
    public static final String AMOUNT_TO_BUY_LOTTO_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_LOTTO = "%d개를 구매했습니다.\n";
    public static final String LOTTO_NUMBER_MESSAGE = """
        [%s]
        """;
    public static final String COMMA_BLANK_DELIMITER = ", ";

    public static final String COMMA = ",";

    public static final String STATISTIC_MESSAGE = """
        당첨 통계
        ---
        3개 일치 (%s원) - %d개
        4개 일치 (%s원) - %d개
        5개 일치 (%s원) - %d개
        5개 일치, 보너스 볼 일치 (%s원) - %d개
        6개 일치 (%s원) - %d개 
        """;

    public static final String THOUSANDS_SEPARATOR = "%,d";

    public static final String TOTAL_YIELD_RATE = """
        총 수익률은 %.1f%%입니다.
        """;

}
