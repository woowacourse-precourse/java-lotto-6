package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.ResultRepository;

import java.util.Comparator;
import java.util.stream.Collectors;

public class OutputView {

    public void printCount(int count) {
        //System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public void printLotto(Lotto lotto) {
        String numbers = lotto.getNumbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + numbers + "]");
    }

    public void printWinningStatistics(ResultRepository resultRepository) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(resultRepository);
    }

    public void printRateOfReturn(Double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
