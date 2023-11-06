package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String LOTTO_GENERATION_MESSAGE = "난수로 생성된 로또 번호 출력";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String SEPARATOR = "--------------";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f%%입니다.";

    public static void printGeneratedLotto(List<Lotto> lottos) {
        System.out.println(LOTTO_GENERATION_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(SEPARATOR);

    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
    }
}
