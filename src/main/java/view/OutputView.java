package view;

import domain.Lotto;
import domain.Result;

public class OutputView {
    private static final String PAYMENT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_TITLE_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String EARNINGS_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printNumberOfLottoTickets(long payment) {
        long lottoTickets = Lotto.countLottoTickets(payment);
        System.out.println(String.format(PAYMENT_MESSAGE, lottoTickets));
    }

    public static void printLottoTickets(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE_MESSAGE);
        System.out.println(LINE);
    }

    public static void printWinningResults(Result result) {
        System.out.println(result);
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.println(String.format(EARNINGS_RATE_MESSAGE, earningsRate));
    }
}
