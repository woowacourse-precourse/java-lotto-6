package lotto.controller;

import lotto.model.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.controller.Rank.getRank;

public class winningController {
    public static int compareLottoAndWinningNumber(List<Integer> lotto, List<Integer> winning) {
        Set<Integer> uniqueLotto = new HashSet<>(lotto);
        Set<Integer> uniqueWinning = new HashSet<>(winning);
        uniqueLotto.retainAll(uniqueWinning);
        return uniqueLotto.size();
    }

    public static boolean compareLottoAndBonus(List<Integer> lotto, int bonus) {
        Set<Integer> uniqueLotto = new HashSet<>(lotto);
        return uniqueLotto.contains(bonus);
    }

    public static Rank findRank(int resultCount) {
        Rank rank = getRank(resultCount);
        if (rank != null) {
            return rank;
        }
        return null;
    }

    public static Rank checkIfSecondOrThird(Lotto lotto, int bonus) {
        if (compareLottoAndBonus(lotto.getLotto(), bonus)) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }
}
