package lotto.domain.message;

import java.text.DecimalFormat;

final class MessageConstant {

    public final static String INPUT_PURCHASE_CASH_AMOUNT = "구입금액을 입력해 주세요.";
    public final static String PURCHASED_LOTTERIES_FORMAT = "\n%d개를 구매했습니다.";

    public final static String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public final static String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public final static String LOTTERIES_NUMBERS_FORMAT = "[%s]";
    public final static String LOTTERIES_NUMBERS_DELIMITER = ", ";

    public final static String WINNING_STATISTICS_START = "\n당첨 통계\n---";
    public final static String WINNING_STATISTIC_INFORMATION_FORMAT = "%s (%s원) - %d개";
    public final static DecimalFormat PRIZE_FORMAT = new DecimalFormat("###,###,###");
    public final static String NEXT_LINE = "\n";

    public final static String YIELD_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";
    public final static DecimalFormat YIELD_FORMAT = new DecimalFormat("#.#");

}
