package lotto.view.output;

import static lotto.constant.PrintOutMessage.COUNT_SUFFIX;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_BONUS_NUMBER;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_PURCHASE_PRICE;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_WINNER_NUMBER;
import static lotto.constant.PrintOutMessage.PRINT_LOTTO_COUNT;
import static lotto.constant.PrintOutMessage.PRINT_WINNING_STATISTICS;
import static lotto.constant.Rank.FIVE_AND_BONUS_MATCH;
import static lotto.constant.Rank.FIVE_MATCH;
import static lotto.constant.Rank.FOUR_MATCH;
import static lotto.constant.Rank.SIX_MATCH;
import static lotto.constant.Rank.THREE_MATCH;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.Rank;
import lotto.model.CompareResult;
import lotto.model.Lotto;

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

    public void printMatchingCount(Map<CompareResult, Integer> matchingCount) {
        printMatchCountExceptFive(matchingCount);
        printMatchCountForFive(matchingCount);
    }

    private void printMatchCountExceptFive(Map<CompareResult, Integer> matchingCount) {
        Map<Integer, Rank> matchNumberToMessage = new HashMap<>();
        matchNumberToMessage.put(THREE_MATCH.getMatchCount(), THREE_MATCH);
        matchNumberToMessage.put(FOUR_MATCH.getMatchCount(), FOUR_MATCH);
        matchNumberToMessage.put(SIX_MATCH.matchCount, SIX_MATCH);

        for (int i = 3; i <= 6; i++) {
            if (i != FIVE_MATCH.matchCount) {
                int count = matchingCount.getOrDefault(new CompareResult(i, false), 0)
                        + matchingCount.getOrDefault(new CompareResult(i, true), 0);
                System.out.println(matchNumberToMessage.get(i).message + count + COUNT_SUFFIX.message);
            }
        }
    }

    private void printMatchCountForFive(Map<CompareResult, Integer> matchingCount) {
        System.out.println(FIVE_MATCH.message
                + matchingCount.getOrDefault(new CompareResult(FIVE_MATCH.matchCount, FIVE_MATCH.isMatchBonus), 0)
                + COUNT_SUFFIX.message);
        System.out.println(FIVE_AND_BONUS_MATCH.message
                + matchingCount.getOrDefault(
                new CompareResult(FIVE_AND_BONUS_MATCH.matchCount, FOUR_MATCH.isMatchBonus), 0)
                + COUNT_SUFFIX.message);
    }


    public void printEarningPercent(String formattedPercent) {
        System.out.println(String.format("총 수익률은 %s%%입니다.", formattedPercent));
    }
}
