package view;

import java.util.Arrays;
import java.util.List;
import model.Lotto;
import model.Prize;
import model.PrizeResult;

public class OutputView {
    private static final String LOTTO_TICKET_COUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String NEWLINE = "\n";
    private static final String RESULT_SHOW_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String RESULT_MESSAGE_WITH_BONUS_BALL = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RESULT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoTicketCount(int lottoTicketCount) {
        System.out.println();
        System.out.println(String.format(LOTTO_TICKET_COUNT_MESSAGE, lottoTicketCount));
    }
    public static void printLottoTicket(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(PrizeResult prizeResult) {
        System.out.println();
        System.out.println(RESULT_SHOW_MESSAGE);
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.NONE))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));
    }

    private static String getPrintResultPrize(Prize prize, PrizeResult prizeResult) {
        String messageTemplate = (prize == Prize.SECOND) ? RESULT_MESSAGE_WITH_BONUS_BALL : RESULT_MESSAGE;
        return String.format(messageTemplate, prize.getMatchNumberCount(),
                String.format("%,d", prize.getMoney()), prizeResult.getPrizeCount(prize));
    }

    public static void printEarningRate(double earningRate) {
        System.out.println(String.format(RESULT_RATE_MESSAGE, earningRate));
    }
}
