package lotto.util;

import lotto.io.output.Writer;

public class ViewConstants {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = Writer.NEW_LINE + "보너스 번호를 입력해 주세요.";

    public static final String PURCHASED_TICKETS_MESSAGE = "%s%d개를 구매했습니다.";
    public static final String DELIMITER = ", ";
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";
    public static final String TEMPLATE = """
             
                    당첨 통계
                    ---
                    3개 일치 (5,000원) - %d개
                    4개 일치 (50,000원) - %d개
                    5개 일치 (1,500,000원) - %d개
                    5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                    6개 일치 (2,000,000,000원) - %d개
                    총 수익률은 %s%%입니다.
            """.replaceAll("( ){2,}", "");

    public static final String NUMBER_FORMAT_PATTERN = "###,###.0";
    public static final double ZERO_PROFIT_RATE = 0.0;
    public static final String ZERO_PROFIT_RATE_STRING = "0.0";
}
