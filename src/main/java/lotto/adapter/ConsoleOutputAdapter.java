package lotto.adapter;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.port.OutputPort;

public class ConsoleOutputAdapter implements OutputPort {
    private static final String OUTPUT_PURCHASE_AMOUNT = "%d개를 구입했습니다.";
    private static final String OUTPUT_DRAW_NUMBERS = "당첨 통계\n---";
    private static final String OUTPUT_BONUS_NUMBER = "총 수익률은 %f.2입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.println(String.format(OUTPUT_PURCHASE_AMOUNT, lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(String.format("[%s]", lotto.getNumbers().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "))));
        }
    }

    public void printWinningStatistics() {
        System.out.println(OUTPUT_DRAW_NUMBERS);

        // TODO: 출력 구현

    }

    public void printProfitRate(Double profitRate) {
        System.out.println(String.format(OUTPUT_BONUS_NUMBER, profitRate));
    }

}
