package lotto.view;

import lotto.constants.WinningPrize;
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
    private static final String THREE_MATCHES = "3개 일치 (%s원) - %d개";
    private static final String FOUR_MATCHES = "4개 일치 (%s원) - %d개";
    private static final String FIVE_MATCHES = "5개 일치 (%s원) - %d개";
    private static final String FIVE_MATCHES_AND_BONUS_NOT_MATCHES = "5개 일치, 보너스 볼 일치 (%s원) - 0개";
    private static final String SIX_MATCHES = "6개 일치 (%s원) - %d개";
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
        double rateOfResult = winningStatisticsDTO.rateOfReturn();
        System.out.println(String.format(THREE_MATCHES, addCommasToNumbers(WinningPrize.FIFTH_PLACE_RETURN.getValue()), lottoResult.getFifth_place()));
        System.out.println(String.format(FOUR_MATCHES, addCommasToNumbers(WinningPrize.FORTH_PLACE_RETURN.getValue()), lottoResult.getForth_place()));
        System.out.println(String.format(FIVE_MATCHES, addCommasToNumbers(WinningPrize.THIRD_PLACE_RETURN.getValue()), lottoResult.getThird_place()));
        System.out.println(String.format(FIVE_MATCHES_AND_BONUS_NOT_MATCHES,addCommasToNumbers(WinningPrize.SECOND_PLACE_RETURN.getValue()), lottoResult.getSecond_place()));
        System.out.println(String.format(SIX_MATCHES, addCommasToNumbers(WinningPrize.FIRST_PLACE_RETURN.getValue()), lottoResult.getFirst_place()));
        System.out.println(String.format(TOTAL_RATE_OF_RETURN,  rateOfResult));
    }

    public static String addCommasToNumbers(int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(amount);
    }
}
