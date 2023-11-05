package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;
import lotto.view.OutputView;

public class OutputController {
    private final OutputView outputView;
    private final String NEW_LINE = "\n";

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printLottoTicketsCount(List<Lotto> lottoTickets) {
        String lottoTicketsCountText = creatLottoTicketsCountText(lottoTickets);
        outputView.updateLottoTicketsCountText(lottoTicketsCountText);
        outputView.renderLottoTicketsCountText();
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        String lottoTicketsText = createLottoTicketsText(lottoTickets);
        outputView.updateLottoTicketsText(lottoTicketsText);
        outputView.renderLottoTicketsText();
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        String winningStatisticsText = createWinningStatisticsText(winningStatistics);
        outputView.updateWinningStatisticsText(winningStatisticsText);
        outputView.renderWinningStatisticsText();
    }

    public void printRateOfReturn(WinningStatistics winningStatistics) {
        String rateOfReturnText = createRateOfReturnText(winningStatistics);
        outputView.updateRateOfReturnText(rateOfReturnText);
        outputView.renderRateOfReturnText();
    }

    public String creatLottoTicketsCountText(List<Lotto> lottoTickets) {
        return String.valueOf(lottoTickets.size());
    }

    public String createLottoTicketsText(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lotto -> {
            sb.append(lotto.toString()).append(NEW_LINE);
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
            sb.append(String.format(lottoPrize.getStatisticsFormat(), count)).append(NEW_LINE);
        }
        return sb.toString();
    }

    public String createRateOfReturnText(WinningStatistics winningStatistics) {
        return String.valueOf(winningStatistics.getRateOfReturn());
    }
}