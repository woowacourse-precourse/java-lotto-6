package lotto.view.output;

import static lotto.constant.PrintOutMessage.COUNT_SUFFIX;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_BONUS_NUMBER;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_PURCHASE_PRICE;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_WINNER_NUMBER;
import static lotto.constant.PrintOutMessage.PRINT_LOTTO_COUNT;
import static lotto.constant.PrintOutMessage.PRINT_WINNING_STATISTICS;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.PrintOutMessage;
import lotto.model.Lotto;
import lotto.model.Statistics;

public class OutputView {
    public void printInputPurchasePrice() {
        System.out.println(PLZ_INPUT_PURCHASE_PRICE.message);
    }

    public void printLottoCount(int count) {
        System.out.println(count + PRINT_LOTTO_COUNT.message);
    }

    public void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printWinnerNumber() {
        System.out.println(PLZ_INPUT_WINNER_NUMBER.message);
    }

    public void printBonusNumber() {
        System.out.println(PLZ_INPUT_BONUS_NUMBER.message);
    }

    public void printWinningStatistics() {
        System.out.println(PRINT_WINNING_STATISTICS.message);
    }

    public void printMatchingCount(Map<Statistics, Integer> matchingCount) {
        printMatchCountExceptFive(matchingCount);
        printMatchCountForFive(matchingCount);
    }

    private void printMatchCountExceptFive(Map<Statistics, Integer> matchingCount) {
        Map<Integer, PrintOutMessage> matchNumberToMessage = new HashMap<>();
        matchNumberToMessage.put(3, PrintOutMessage.THREE_MATCH);
        matchNumberToMessage.put(4, PrintOutMessage.FOUR_MATCH);
        matchNumberToMessage.put(6, PrintOutMessage.SIX_MATCH);

        for (int i = 3; i <= 6; i++) {
            if (i != 5) {
                int count = matchingCount.getOrDefault(new Statistics(i, false), 0)
                        + matchingCount.getOrDefault(new Statistics(i, true), 0);
                System.out.println(matchNumberToMessage.get(i).message + count + COUNT_SUFFIX.message);
            }
        }
    }

    private void printMatchCountForFive(Map<Statistics, Integer> matchingCount) {
        System.out.println(PrintOutMessage.FIVE_MATCH.message
                + matchingCount.getOrDefault(new Statistics(5, false), 0)
                + COUNT_SUFFIX.message);
        System.out.println(PrintOutMessage.FIVE_AND_BONUS_MATCH.message
                + matchingCount.getOrDefault(new Statistics(5, true), 0)
                + COUNT_SUFFIX.message);
    }


    public void printEarningPercent(String formattedPercent) {
        System.out.println(String.format("총 수익률은 %s%%입니다.", formattedPercent));
    }
}
