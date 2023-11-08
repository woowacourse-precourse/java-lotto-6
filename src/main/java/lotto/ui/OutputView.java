package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_MESSAGE = """
        당첨 통계
        ---
        """;

    private static final String COUNT_FORMAT = "%d개를 구매했습니다.\n";

    public OutputView() {
    }

    public void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public void printInputWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printBoughtLottos(List<Lotto> lottos, long count) {
        System.out.printf(COUNT_FORMAT.formatted(count));
        lottos.forEach(System.out::println);
    }

    public void printStatistics(String formattedStatistics, String formattedProfit) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(formattedStatistics);
        System.out.println(formattedProfit);
    }
}
