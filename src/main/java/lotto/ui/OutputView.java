package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printInputMoneyMessage() {
        System.out.println(INFO_MESSAGE.INPUT_MONEY_MESSAGE.getValue());
    }

    public void printInputWinningNumberMessage() {
        System.out.println(INFO_MESSAGE.INPUT_WINNING_NUMBER_MESSAGE.getValue());
    }

    public void printInputBonusNumberMessage() {
        System.out.println(INFO_MESSAGE.INPUT_BONUS_NUMBER_MESSAGE.getValue());
    }

    public void printBoughtLottos(List<Lotto> lottos, long count) {
        System.out.printf(INFO_MESSAGE.COUNT_FORMAT.getValue().formatted(count));
        lottos.forEach(System.out::println);
    }

    public void printStatistics(String formattedStatistics, String formattedProfit) {
        System.out.println(INFO_MESSAGE.STATISTICS_MESSAGE.getValue());
        System.out.println(formattedStatistics);
        System.out.println(formattedProfit);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
