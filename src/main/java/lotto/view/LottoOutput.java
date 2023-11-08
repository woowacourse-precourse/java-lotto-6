package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class LottoOutput {
    private static final DecimalFormat EARNINGS_RATE_FORMAT = new DecimalFormat("0.0%");

    public String requestAmountMessage() {
        return "구매금액을 입력해 주세요.";
    }

    public String printNumberOfTicketsMessage(int count) {
        return count + "개를 구매했습니다.";
    }

    public String getLottoNumbersMessage(List<Integer> lottoNumbers) {
        return lottoNumbers.toString();
    }

    public String getErrorMessage(String message) {
        return message;
    }

    public String requestWinningNumber() {
        return "당첨 번호를 입력해 주세요.";
    }

    public String requestBonusNumber() {
        return "보너스 번호를 입력해 주세요.";
    }

    public void printPrizeStatistics(List<String > statisticsLines) {

        printPrizeStatisticsHeader();
        statisticsLines.forEach(System.out::println);
    }

    public void printPrizeStatisticsHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }



    public void printEarningsRate(BigDecimal earningsRate) {
        System.out.println("총 수익률은 " + formatEarningsRate(earningsRate) + "입니다.");
    }

    private String formatEarningsRate(BigDecimal earningsRate) {
        BigDecimal percentEarningsRate = earningsRate.divide(BigDecimal.valueOf(100));
        return EARNINGS_RATE_FORMAT.format(percentEarningsRate);
    }

}
