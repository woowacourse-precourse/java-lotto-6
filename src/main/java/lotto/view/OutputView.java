package lotto.view;

import lotto.constants.GameNumberConstants;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.WinningStatisticsDTO;

import java.text.DecimalFormat;
import java.util.List;


public class OutputView {
    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String BOUGHT_N = "%d개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String N_MATCHES = "%d개 일치 %s(%s원) - %d개";
    private static final String BONUS_BALL_MATCH = "보너스 볼 일치 ";
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
                .forEach((lottoTicket) -> System.out.println(lottoTicket.getNumbers()));
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
        LottoResult lottoResult = winningStatisticsDTO.lottoResult();
        for (int index = GameNumberConstants.NUMBER_OF_WINNING_PRIZE.getValue(); index >= 1; index--) {
            String bonusBallMatch = "";
            if (Rank.getHasBonusNumberFromIndex(index) == 1) {
                bonusBallMatch = BONUS_BALL_MATCH;
            }
            System.out.println(String.format(N_MATCHES,
                    Rank.getNumberOfMatchesRequiredFromIndex(index),
                    bonusBallMatch,
                    addCommaToNumbers(Rank.getPrizeFromIndex(index)),
                    lottoResult.getNumberOfPrizeFromIndex(index)));
        }
        System.out.println(String.format(TOTAL_RATE_OF_RETURN,  winningStatisticsDTO.rateOfReturn()));
    }

    public static String addCommaToNumbers(int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(amount);
    }
}
