package lotto.view;

import lotto.constants.GameNumberConstants;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.WinningStatisticsDTO;

import java.util.List;


public class OutputView {
    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String BOUGHT_N = "%d개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String N_MATCHES = "%s개 일치%s (%s원) - %s개";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    private OutputView() {
    }

    public static void printInputPurchaseAmount() {
        System.out.println(INPUT_PAYMENT);
    }

    public static void printLottoTickets(LottoTicketsDTO lottoTicketsDTO) {
        System.out.println("");
        int ticketAmount = lottoTicketsDTO.ticketAmount();
        List<Lotto> lottoTickets = lottoTicketsDTO.lottoTickets();
        System.out.println(String.format(BOUGHT_N, ticketAmount));
        lottoTickets.stream()
                .forEach((lottoTicket) -> System.out.println(lottoTicket.numbers()));
    }

    public static void printInputWinningNumber() {
        System.out.println("");
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println("");
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printWinningStatistics(WinningStatisticsDTO winningStatisticsDTO) {
        System.out.println("");
        System.out.println(WINNING_STATISTICS);
        String[][] winningStatisticsStrings = winningStatisticsDTO.winningStatisticsStrings();
        for (int index = GameNumberConstants.NUMBER_OF_WINNING_PRIZE.getValue(); index >= 1; index--) {
            System.out.println(String.format(
                    N_MATCHES,
                    winningStatisticsStrings[index][0],
                    winningStatisticsStrings[index][1],
                    winningStatisticsStrings[index][2],
                    winningStatisticsStrings[index][3]));
        }
        System.out.println(String.format(TOTAL_RATE_OF_RETURN,  winningStatisticsDTO.rateOfReturn()));
    }
}
