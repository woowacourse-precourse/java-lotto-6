package lotto.view;

public class OutputView {
    public static final String LOTTO_TICKETS_COUNT_FORMAT = "%s개를 구매했습니다.";
    public static final String LOTTO_TICKETS_FORMAT = "%s";
    public static final String WINNING_STATISTICS_FORMAT = "당첨 통계\n---\n%s";
    public static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %s%%입니다.";

    private String lottoTicketsCountText;
    private String lottoTicketsText;
    private String winningStatisticsText;
    private String rateOfReturnText;

    public OutputView() {
        // default text
        lottoTicketsCountText = LOTTO_TICKETS_COUNT_FORMAT;
        lottoTicketsText = LOTTO_TICKETS_FORMAT;
        winningStatisticsText = WINNING_STATISTICS_FORMAT;
        rateOfReturnText = RATE_OF_RETURN_FORMAT;
    }

    public void renderLottoTicketsCountText() {
        System.out.println(lottoTicketsCountText);
    }

    public void renderLottoTicketsText() {
        System.out.println(lottoTicketsText);
    }

    public void renderWinningStatisticsText() {
        System.out.println(winningStatisticsText);
    }

    public void renderRateOfReturnText() {
        System.out.println(rateOfReturnText);
    }

    public void updateLottoTicketsCountText(String count) {
        lottoTicketsCountText = String.format(LOTTO_TICKETS_COUNT_FORMAT, count);
    }

    public void updateLottoTicketsText(String lottoTickets) {
        lottoTicketsText = String.format(LOTTO_TICKETS_FORMAT, lottoTickets);
    }

    public void updateWinningStatisticsText(String winningStatistics) {
        winningStatisticsText = String.format(WINNING_STATISTICS_FORMAT, winningStatistics);
    }

    public void updateRateOfReturnText(String rateOfReturn) {
        rateOfReturnText = String.format(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }
}