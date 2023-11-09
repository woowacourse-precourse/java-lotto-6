package lotto.view;

public class OutputView {
    public static final String LOTTO_TICKETS_COUNT_TEXT_FORMAT = "%s개를 구매했습니다.";
    public static final String LOTTO_TICKETS_TEXT_FORMAT = "%s";
    public static final String PRIZE_COUNTER_TEXT_FORMAT = "당첨 통계\n---\n%s";
    public static final String RATE_OF_RETURN_TEXT_FORMAT = "총 수익률은 %s%%입니다.";

    private String lottoTicketsCountText;
    private String lottoTicketsText;
    private String prizeCounterText;
    private String rateOfReturnText;

    public OutputView() {
        // default text
        lottoTicketsCountText = LOTTO_TICKETS_COUNT_TEXT_FORMAT;
        lottoTicketsText = LOTTO_TICKETS_TEXT_FORMAT;
        prizeCounterText = PRIZE_COUNTER_TEXT_FORMAT;
        rateOfReturnText = RATE_OF_RETURN_TEXT_FORMAT;
    }

    public void renderLottoTicketsCountText() {
        System.out.println(lottoTicketsCountText);
    }

    public void renderLottoTicketsText() {
        System.out.println(lottoTicketsText);
    }

    public void renderPrizeCounterText() {
        System.out.println(prizeCounterText);
    }

    public void renderRateOfReturnText() {
        System.out.println(rateOfReturnText);
    }

    public void updateLottoTicketsCountText(String count) {
        lottoTicketsCountText = String.format(LOTTO_TICKETS_COUNT_TEXT_FORMAT, count);
    }

    public void updateLottoTicketsText(String lottoTickets) {
        lottoTicketsText = String.format(LOTTO_TICKETS_TEXT_FORMAT, lottoTickets);
    }

    public void updatePrizeCounterText(String prizeCounter) {
        prizeCounterText = String.format(PRIZE_COUNTER_TEXT_FORMAT, prizeCounter);
    }

    public void updateRateOfReturnText(String rateOfReturn) {
        rateOfReturnText = String.format(RATE_OF_RETURN_TEXT_FORMAT, rateOfReturn);
    }
}