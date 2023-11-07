package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoTickets;
import lotto.domain.Result;

public class OutputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_NUMBER_OUTPUT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String OPEN_BRACKET = "[";
    private static final String COMMA = ", ";
    private static final String CLOSE_BRACKET = "]";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_OUTPUT_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT_MESSAGE = "%s%d개\n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printMoneyInputMessage() {
        printMessage(MONEY_INPUT_MESSAGE);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
