package lotto.view;

import static lotto.model.Prize.SECOND;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.PlayerLottos;
import lotto.model.Prize;
import lotto.model.ProfitCalculator;
import lotto.model.Statistics;

public class OutputView {

    private enum OutputMessage {
        NUMBER_OF_LOTTO_TICKETS("%d개를 구매했습니다.\n"),
        OUTPUT_STATISTICS("당첨 통계\n---"),
        OUTPUT_MATCH_RESULT("%d개 일치 (%s원) - %d개\n"),
        OUTPUT_SECOND_MATCH_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
        OUTPUT_PROFIT_RATIO("총 수익률은 %.1f%%입니다."),
        OUTPUT_DECIMAL_FORMAT("###,###");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }

    private static final DecimalFormat formatter = new DecimalFormat(OutputMessage.OUTPUT_DECIMAL_FORMAT.message);

    public static void outputNumberOfLottoTicks(int numberOfLottoTickets) {
        System.out.printf(OutputMessage.NUMBER_OF_LOTTO_TICKETS.message, numberOfLottoTickets);
    }

    public static void outputLottoPlayerNumbers(PlayerLottos playerLottos) {
        playerLottos.getPlayerLottos()
                .stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void outputStatistics(Statistics statistics) {
        System.out.println(OutputMessage.OUTPUT_STATISTICS.message);
        Map<Prize, Integer> result = statistics.getResult();

        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            if (entry.getKey() == Prize.NONE) continue;
            if (entry.getKey() == SECOND) {
                printSecondPrize(entry.getValue());
                continue;
            }
            printOtherPrize(entry);
        }
    }

    public static void outputProfitRatio(ProfitCalculator profitCalculator) {
        System.out.printf(OutputMessage.OUTPUT_PROFIT_RATIO.message, profitCalculator.getProfitRatio());
    }

    private static void printSecondPrize(int count) {
        System.out.printf(OutputMessage.OUTPUT_SECOND_MATCH_RESULT.message,
                SECOND.getMatch(),
                formatter.format(SECOND.getPrize()),
                count);
    }

    private static void printOtherPrize(Map.Entry<Prize, Integer> entry) {
        System.out.printf(OutputMessage.OUTPUT_MATCH_RESULT.message
                ,entry.getKey().getMatch(),
                formatter.format(entry.getKey().getPrize()),
                entry.getValue());
    }
}
