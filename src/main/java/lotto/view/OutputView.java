package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public static final String LINE_SEPARATOR = "\n";
    public static final String LOTTO_BUY_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String NO_WINNING_MESSAGE = "당첨 되지 않음 - ";
    private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String[] PRIZE_MESSAGE = {
        NO_WINNING_MESSAGE, FIRST_PRIZE_MESSAGE, SECOND_PRIZE_MESSAGE,
        THIRD_PRIZE_MESSAGE, FOURTH_PRIZE_MESSAGE, FIFTH_PRIZE_MESSAGE
    };
    private static final String COUNT_UNIT = "개";
    public static final String PROFIT_PREFIX = "총 수익률은 ";
    public static final String PROFIT_SUFFIX = "%입니다.";
    private static final String ERROR = "[ERROR] ";

    public static void printLottoBuy(int lottoNums) {
        System.out.println(LINE_SEPARATOR + lottoNums + LOTTO_BUY_MESSAGE);
    }

    public static void printAllLottoNumber(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    public static void printLottoResult(List<Integer> lottoResult) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 5; i > 0; i--) {
            System.out.println(PRIZE_MESSAGE[i] + lottoResult.get(i) + COUNT_UNIT);
        }
    }

    public static void printProfitRate(Double profit) {
        System.out.println(PROFIT_PREFIX + profit + PROFIT_SUFFIX);
    }

    public static void printErrorMessage(String Message) {
        System.out.println(ERROR + Message);
    }

}
