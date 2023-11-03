package lotto.controller.userIO;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;
import lotto.view.OutputView;

public class OutputController {
    private OutputView outputView;

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printLottoTicketsCount(int count) {
        System.out.println(outputView.lottoTicketsCountTemplate(count));
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(outputView.lottoTicketsTemplate(lottoTickets));
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(outputView.winningStatisticsTemplate(winningStatistics));
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(outputView.rateOfReturnTemplate(rateOfReturn));
    }
}
