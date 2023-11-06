package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.controller.Rank.getRank;

public class winningController {

    public static HashMap<Rank, Integer> createResult(List<Lotto> lottery, List<Integer> winningNumbers, BonusNumber bonus) {
        HashMap<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottery) {
            int resultCount = compareLottoAndWinningNumber(lotto.getLotto(), winningNumbers);
            Rank resultRank = findRank(resultCount);
            if (resultRank == null) {
                continue;
            }
            if (resultRank.getCorrectNum() == 5) {
                resultRank = checkIfSecondOrThird(lotto, bonus.getBonusNumber());
            }
            result.put(resultRank, result.getOrDefault(resultRank, 0)+1);
        }
        return result;
    }

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
