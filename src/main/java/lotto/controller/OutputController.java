package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;
import lotto.view.OutputView;

public class OutputController {
    private final OutputView outputView;

    public OutputController() {
        outputView = new OutputView();
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        String lottoTicketsCountText = creatLottoTicketsCountText(lottoTickets);
        String lottoTicketsText = createLottoTicketsText(lottoTickets);

        outputView.updateLottoTicketsCountText(lottoTicketsCountText);
        outputView.updateLottoTicketsText(lottoTicketsText);
        outputView.renderLottoTicketsCountText();
        outputView.renderLottoTicketsText();
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        String winningStatisticsText = createWinningStatisticsText(winningStatistics);
        String rateOfReturnText = createRateOfReturnText(winningStatistics);

        outputView.updateWinningStatisticsText(winningStatisticsText);
        outputView.updateRateOfReturnText(rateOfReturnText);
        outputView.renderWinningStatisticsText();
        outputView.renderRateOfReturnText();
    }
    
    public String creatLottoTicketsCountText(List<Lotto> lottoTickets) {
        return String.valueOf(lottoTickets.size());
    }

    public String createLottoTicketsText(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lotto -> {
            sb.append(lotto.toString()).append("\n");
        });
        return sb.toString();
    }

    public String createWinningStatisticsText(WinningStatistics winningStatistics) {
        Map<LottoPrize, Integer> prizeCounter = winningStatistics.getPrizeCounter();
        StringBuilder sb = new StringBuilder();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }
            int count = prizeCounter.get(lottoPrize);
            sb.append(String.format(lottoPrize.getStatisticsFormat(), count)).append("\n");
        }
        return sb.toString();
    }

    public String createRateOfReturnText(WinningStatistics winningStatistics) {
        return String.valueOf(winningStatistics.getRateOfReturn());
    }
}