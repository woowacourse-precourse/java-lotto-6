package lotto.view;

import lotto.domain.result.Result;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    private static final String PRINT_STATISTICS_LINE = "\n당첨통계\n---";
    private static final String PRINT_PURCHASE_LOTTOS_FORMAT = "\n%d개를 구매했습니다.\n%s";
    private static final String PRINT_PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String PRINT_STATISTICS_FORMAT = "%d개 일치%s (%s원) - %d개\n";
    private static final String PRINT_BONUS_NUMBER_HIT = ", 보너스 볼 일치";
    private static final String PRINT_BONUS_NUMBER_NO_HIT = "";
    
    private static final DecimalFormat PRINT_PRIZE_FORMAT = new DecimalFormat("###,###");

    private OutputView() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printResult(ResultDto resultDto) {
        System.out.println(PRINT_STATISTICS_LINE);
        printStatistics(resultDto.statistics());

        System.out.printf((PRINT_PROFIT_FORMAT) + "%n", resultDto.profit());
    }

    private static void printStatistics(Map<Result, Integer> statistics) {
        StringBuilder statisticsResult = new StringBuilder();
        statistics.forEach((result, count) -> {
            String bonus = getBonusMessage(result);

            statisticsResult.append(String.format(
                    PRINT_STATISTICS_FORMAT, result.getHitCount(), bonus, PRINT_PRIZE_FORMAT.format(result.getPrize()), count));

        });
        System.out.print(statisticsResult);
    }

    private static String getBonusMessage(Result result) {
        String bonus = PRINT_BONUS_NUMBER_NO_HIT;
        if (result.isMustHitBonus()) {
            bonus = PRINT_BONUS_NUMBER_HIT;
        }
        return bonus;
    }

    public static void printPurchaseLottos(LottosDto lottosDto) {
        StringBuilder lottos = new StringBuilder();
        lottosDto.purchaseLotto()
                .forEach(lottoDto -> lottos.append(lottoDto.toString()).append("\n"));

        System.out.printf(PRINT_PURCHASE_LOTTOS_FORMAT, lottosDto.purchaseNumber(), lottos);
    }
}
