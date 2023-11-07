package lotto.view;

import static lotto.model.Prize.SECOND;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.LottoPlayerNumber;
import lotto.model.LottoPlayerNumbers;
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
        ;


        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }

    public static void outputNumberOfLottoTicks(int numberOfLottoTickets) {
        System.out.printf(OutputMessage.NUMBER_OF_LOTTO_TICKETS.message, numberOfLottoTickets);
    }

    public static void outputLottoPlayerNumbers(LottoPlayerNumbers lottoPlayerNumbers) {
        lottoPlayerNumbers.getLottoPlayerNumbers()
                .stream()
                .map(LottoPlayerNumber::getLottoPlayerNumber)
                .forEach(System.out::println);
    }

    public static void outputStatistics(Statistics statistics) {

        System.out.println(OutputMessage.OUTPUT_STATISTICS.message);
        Map<Prize, Integer> result = statistics.getResult();
        DecimalFormat formatter = new DecimalFormat("###,###");

        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            if (entry.getKey() == Prize.NONE) continue;
            if (entry.getKey() == SECOND) {
                System.out.printf(OutputMessage.OUTPUT_SECOND_MATCH_RESULT.message,
                        SECOND.getMatch(),
                        formatter.format(SECOND.getPrize()),
                        entry.getValue());
                continue;
            }

            System.out.printf(OutputMessage.OUTPUT_MATCH_RESULT.message
                    ,entry.getKey().getMatch(),
                    formatter.format(entry.getKey().getPrize()),
                    entry.getValue());
        }
    }

    public static void outputProfitRatio(ProfitCalculator profitCalculator) {
        System.out.printf(OutputMessage.OUTPUT_PROFIT_RATIO.message, profitCalculator.getProfitRatio());
    }
}
