package lotto.view;

import java.text.NumberFormat;
import java.util.Locale;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.dto.LottosDto;
import lotto.dto.ResultsDto;

public class OutputView {

    private static final String NumberOfTicketsFormat = "\n%d개를 구매했습니다.\n";
    private static final String winningStatistics = "\n당첨 통계";
    private static final String line = "---";
    private static final String winningStatisticsFormat = "%d개 일치";
    private static final String winningStatisticsBonusFormat = ", 보너스 볼 일치";
    private static final String winningStatisticsCountFormat = " (%s원) - %d개";
    private static final String profitRateFormat = "총 수익률은 %.1f%%입니다.";

    public static void printNumberOfTickets(int purchaseNumber) {
        System.out.printf(NumberOfTicketsFormat, purchaseNumber);
    }

    public static void printLottoNumbers(LottosDto lottosDto) {
        lottosDto.lottos().stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }

    public static void printWinningStatistics(ResultsDto resultsDto) {
        System.out.println(winningStatistics);
        System.out.println(line);
        printResult(resultsDto);
    }

    private static void printResult(ResultsDto resultsDto) {
        for(Result r : resultsDto.results()) {
            System.out.printf(winningStatisticsFormat, r.getMatchCount());
            if(r == Result.SECOND) {
                System.out.printf(winningStatisticsBonusFormat);
            }
            System.out.printf(winningStatisticsCountFormat, formatMoney(r.getWinningMoney()), r.getStatus());
            System.out.println();
        }
    }

    private static String formatMoney(int money) {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(money);
    }

    public static void printProfitRate(double profitRate) {
        String formattedProfitRate = String.format(profitRateFormat, profitRate);
        System.out.println(formattedProfitRate);
    }

}