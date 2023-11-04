package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;
import lotto.view.OutputView;

public class OutputController {
    private final OutputView outputView;

    public OutputController() {
        outputView = new OutputView();
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        outputView.updateLottoTicketsUI(lottoTickets);
        outputView.renderLottoTicketsUI();
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        outputView.updateWinningStatisticsUI(winningStatistics);
        outputView.renderWinningStatisticsUI();
    }
}