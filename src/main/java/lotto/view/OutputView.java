package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.ResultRepository;

import java.util.Comparator;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISSTICS = "당첨 통계";
    private static final String PERFORATION_LINE = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printCount(int count) {
        System.out.printf(PURCHASE_MESSAGE, count);
    }

    public void printLotto(Lotto lotto) {
        String numbers = lotto.getNumbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + numbers + "]");
    }

    public void printWinningStatistics(ResultRepository resultRepository) {
        System.out.println(WINNING_STATISSTICS);
        System.out.println(PERFORATION_LINE);
        System.out.println(resultRepository);
    }

    public void printRateOfReturn(Double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
