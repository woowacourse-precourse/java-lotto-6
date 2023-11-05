package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.WinningStatisticsDTO;

import java.util.List;

import static lotto.constants.OutputConstants.*;

public class OutputView {

    private OutputView() {}

    public static void printInputPurchaseAmount() {
        System.out.println(INPUT_PAYMENT.getValue());
    }

    public static void printLottoTickets(LottoTicketsDTO lottoTicketsDTO) {
        System.out.println("");
        int ticketAmount = lottoTicketsDTO.ticketAmount();
        List<Lotto> lottoTickets = lottoTicketsDTO.lottoTickets();
        System.out.println(String.format(BOUGHT_N.getValue(), ticketAmount));
        lottoTickets.stream()
                .forEach((lottoTicket) -> System.out.println(lottoTicket.getNumbers()));
    }

    public static void printInputWinningNumber() {
        System.out.println("");
        System.out.println(INPUT_WINNING_NUMBER.getValue());
    }

    public static void printInputBonusNumber() {
        System.out.println("");
        System.out.println(INPUT_BONUS_NUMBER.getValue());
    }

    public static void printWinningStatistics(WinningStatisticsDTO winningStatisticsDTO) {
        System.out.println("");
        System.out.println(WINNING_STATISTICS.getValue());
        LottoResult lottoResult = winningStatisticsDTO.lottoResult();
        double rateOfResult = winningStatisticsDTO.rateOfReturn();
        System.out.println(String.format(THREE_MATCHES.getValue(), lottoResult.getFifth_place()));
        System.out.println(String.format(FOUR_MATCHES.getValue(), lottoResult.getForth_place()));
        System.out.println(String.format(FIVE_MATCHES.getValue(), lottoResult.getThird_place()));
        System.out.println(String.format(FIVE_MATCHES_AND_BONUS_NOT_MATCHES.getValue(), lottoResult.getSecond_place()));
        System.out.println(String.format(SIX_MATCHES.getValue(), lottoResult.getFirst_place()));
        System.out.println(String.format(TOTAL_RATE_OF_RETURN.getValue(), rateOfResult));
    }
}
