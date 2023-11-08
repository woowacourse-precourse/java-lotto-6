package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class LottoOutput {

    private static final String REQUEST_AMOUNT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String PRINT_NUMBER_OF_TICKETS_MESSAGE = "%n%d개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String PRIZE_STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String TOTAL_EARNINGS_RATE_MESSAGE = "총 수익률은 %s입니다.";
    private static final DecimalFormat EARNINGS_RATE_FORMAT = new DecimalFormat("0.0%");

    public String requestAmountMessage() {
        return REQUEST_AMOUNT_MESSAGE;
    }

    public String printNumberOfTicketsMessage(int count) {
        return String.format(PRINT_NUMBER_OF_TICKETS_MESSAGE, count);
    }

    public String getLottoNumbersMessage(List<Integer> lottoNumbers) {
        return lottoNumbers.toString();
    }

    public String getErrorMessage(String message) {
        return message;
    }

    public String requestWinningNumber() {
        return REQUEST_WINNING_NUMBER;
    }

    public String requestBonusNumber() {
        return REQUEST_BONUS_NUMBER;
    }

    public void printPrizeStatistics(List<String > statisticsLines) {

        printPrizeStatisticsHeader();
        statisticsLines.forEach(System.out::println);
    }

    public void printPrizeStatisticsHeader() {
        System.out.println(PRIZE_STATISTICS_HEADER);
    }

    public void printEarningsRate(BigDecimal earningsRate) {
        System.out.println(String.format(TOTAL_EARNINGS_RATE_MESSAGE, formatEarningsRate(earningsRate)));
    }

    private String formatEarningsRate(BigDecimal earningsRate) {
        BigDecimal percentEarningsRate = earningsRate.divide(BigDecimal.valueOf(100));
        return EARNINGS_RATE_FORMAT.format(percentEarningsRate);
    }

}
