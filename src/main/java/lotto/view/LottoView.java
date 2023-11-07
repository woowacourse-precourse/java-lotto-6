package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.view.ViewMessage.*;

public class LottoView {


    public void inputMoneyView() {
        System.out.println(INPUT_MONEY_PRINT.getMessage());
    }

    public void outputBuyLottoTicketsView(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + OUTPUT_BUY_TICKET_PRINT.getMessage());
    }

    public void outputLottoTicketNumbersView(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets)
            System.out.println(lotto.getNumbers());
    }

    public void inputWinnerNumbersView() {
        System.out.println(INPUT_WINNER_NUMBERS_PRINT.getMessage());
    }

    public void inputBonusNumberView() {
        System.out.println(INPUT_BONUS_NUMBER_PRINT.getMessage());
    }

    public void outputWinningStatisticsView() {
        System.out.println(OUTPUT_WINNING_STATISTICS_PRINT.getMessage());
    }

    public void outputWinningDescription(String description) {
        System.out.println(description);
    }


    public void outputRevenueView(double revenue) {
        System.out.println(OUTPUT_REVENUE_PREFIX_PRINT.getMessage()
                + String.format("%.1f", revenue)
                + OUTPUT_REVENUE_POSTFIX_PRINT.getMessage());
    }

}
