package lotto.view;

import lotto.constant.LottoRank;
import lotto.constant.PrintMessages;
import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import static lotto.constant.PrintMessages.WINNING_DETAILS;


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

        System.out.println(WINNING_DETAILS);
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
//        System.out.printf(WINNING_DETAILS);
//        System.out.printf(MATCH_NUMBER, RANK_FIVE.getMatchedNormalNum(), RANK_FIVE.getReward(), lottoRanks.stream().filter(rank -> rank == RANK_FIVE).count());
//        System.out.printf(MATCH_NUMBER, RANK_FOUR.getMatchedNormalNum(), RANK_FOUR.getReward(), lottoRanks.stream().filter(rank -> rank == RANK_FOUR).count());
//        System.out.printf(MATCH_NUMBER, RANK_THREE.getMatchedNormalNum(), RANK_THREE.getReward(), lottoRanks.stream().filter(rank -> rank == RANK_THREE).count());
//        System.out.printf(MATCH_NUMBER, RANK_TWO.getMatchedNormalNum(), RANK_TWO.getReward(), lottoRanks.stream().filter(rank -> rank == RANK_TWO).count());
//        System.out.printf(MATCH_NUMBER, RANK_ONE.getMatchedNormalNum(), RANK_ONE.getReward(), lottoRanks.stream().filter(rank -> rank == RANK_ONE).count());
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
}
