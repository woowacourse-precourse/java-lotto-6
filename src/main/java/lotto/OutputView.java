package lotto;

import java.util.List;

public class OutputView {
    private static final String TICKET_NUMBER_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBERS_MESSAGE = "[%d, %d, %d, %d, %d, %d]\n";
    private static final String RESULT_HEADLINE_MESSAGE = "당첨 통계\n---";
    private static final String PRIZE_FREQ_MESSAGE = "%d개 일치 (%s원)%s - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printTicketNumber(long ticketNumber) {
        System.out.printf(TICKET_NUMBER_MESSAGE, ticketNumber);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.printf(LOTTO_NUMBERS_MESSAGE, lotto.getNumbers());
        }
        System.out.println();
    }
}
