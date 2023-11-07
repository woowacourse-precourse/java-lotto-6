package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.ResultRepository;

import java.util.stream.Collectors;

public class OutputView {

    public void printCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public void printLotto(Lotto lotto) {
        String numbers = lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("[" + numbers + "]");
    }

    public void printWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        ResultRepository resultRepository = new ResultRepository();
        resultRepository.toString();
    }

    public void printRateOfReturn(Double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%입니다.", rateOfReturn);
    }
}
