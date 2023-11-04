package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;

public class OutputView {
    public static final String LOTTO_TICKETS_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String STATISTICS_HEADER = "당첨 통계\n---\n";
    public static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    private String lottoTicketsCountText;
    private String lottoTicketsText;
    private String statisticsText;
    private String rateOfReturnText;

    public OutputView() {
        // default text
        lottoTicketsCountText = LOTTO_TICKETS_COUNT_FORMAT;
        lottoTicketsText = "";
        statisticsText = STATISTICS_HEADER;
        rateOfReturnText = RATE_OF_RETURN_FORMAT;
    }

    public void renderLottoTicketsUI() {
        System.out.println(lottoTicketsCountText);
        System.out.println(lottoTicketsText);
    }

    public void renderWinningStatisticsUI() {
        System.out.println(statisticsText);
        System.out.println(rateOfReturnText);
    }

    public void updateLottoTicketsUI(List<Lotto> lottoTickets) {
        lottoTicketsCountText = creatLottoTicketsCountText(lottoTickets);
        lottoTicketsText = createLottoTicketsText(lottoTickets);
    }

    public void updateWinningStatisticsUI(WinningStatistics winningStatistics) {
        statisticsText = createStatisticsText(winningStatistics);
        rateOfReturnText = createRateOfReturnText(winningStatistics);
    }

    public String createRateOfReturnText(WinningStatistics winningStatistics) {
        return String.format(RATE_OF_RETURN_FORMAT, winningStatistics.getRateOfReturn());
    }

    public String creatLottoTicketsCountText(List<Lotto> lottoTickets) {
        return String.format(LOTTO_TICKETS_COUNT_FORMAT, lottoTickets.size());
    }

    public String createLottoTicketsText(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lotto -> {
            sb.append(lotto.toString()).append("\n");
        });
        return sb.toString();
    }

    public String createStatisticsText(WinningStatistics winningStatistics) {
        Map<LottoPrize, Integer> prizeCounter = winningStatistics.getPrizeCounter();
        StringBuilder sb = new StringBuilder();
        sb.append(STATISTICS_HEADER);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }
            int count = prizeCounter.get(lottoPrize);
            sb.append(String.format(lottoPrize.getStatisticsFormat(), count)).append("\n");
        }
        return sb.toString();
    }
}