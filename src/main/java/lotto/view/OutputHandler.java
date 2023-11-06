package lotto.view;

import static lotto.constant.LottoRank.RANK_FIVE;
import static lotto.constant.LottoRank.RANK_FOUR;
import static lotto.constant.LottoRank.RANK_ONE;
import static lotto.constant.LottoRank.RANK_THREE;
import static lotto.constant.LottoRank.RANK_TWO;
import static lotto.constant.PrintMessages.INPUT_BONUS_NUMBER;
import static lotto.constant.PrintMessages.INPUT_PRICE;
import static lotto.constant.PrintMessages.INPUT_WINNING_NUMBER;
import static lotto.constant.PrintMessages.MATCH_NUMBER;
import static lotto.constant.PrintMessages.MATCH_NUMBER_RANK_TWO;
import static lotto.constant.PrintMessages.PURCHASES_NUMBER;
import static lotto.constant.PrintMessages.RATE_OF_RETURN;
import static lotto.constant.PrintMessages.WINNING_DETAILS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputHandler {
    public static void printPurchaseInput() {
        System.out.println(INPUT_PRICE);
    }

    public static void printPurchaseHistory(Lottos lottos) {
        System.out.printf(PURCHASES_NUMBER, lottos.getSize());
        for (Lotto lotto : lottos.getLottos()) {
            printNumbers(lotto.getNumbers());
        }
    }

    public static void printWinningNumberInput() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printBonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printWinningStats(List<LottoRank> lottoRanks) {
        List<LottoRank> ranks = Arrays.asList(RANK_FIVE, RANK_FOUR, RANK_THREE, RANK_TWO, RANK_ONE);

        for (LottoRank rank : ranks) {
            int matchedNormalNum = rank.getMatchedNormalNum();
            String reward = String.format("%,d", rank.getReward());
            long count = lottoRanks.stream().filter(r -> r == rank).count();

            if (rank == RANK_TWO) {
                System.out.printf(MATCH_NUMBER_RANK_TWO, matchedNormalNum, reward, count);
                continue;
            }
            System.out.printf(MATCH_NUMBER, matchedNormalNum, reward, count);
        }
    }

    public static void printWinningStatsSign() {
        System.out.println(WINNING_DETAILS);
    }

    private static void printNumbers(List<Integer> numbers){
        final String LEFT_BRACKET = "[";
        final String RIGHT_BRACKET = "]";

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        String numbersWithComma = sortedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(LEFT_BRACKET + numbersWithComma + RIGHT_BRACKET);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN, rateOfReturn);
    }
}
