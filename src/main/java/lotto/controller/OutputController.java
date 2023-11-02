package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;
import lotto.view.OutputView;

public class OutputController {
    public static void printLottoTicketsCount(int count) {
        System.out.println(OutputView.lottoTicketsCountTemplate(count));
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(OutputView.lottoTicketsTemplate(lottoTickets));
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(OutputView.winningStatisticsTemplate(winningStatistics));
    }

    public static void printRateOfReturn(double winning) {
    }
}
