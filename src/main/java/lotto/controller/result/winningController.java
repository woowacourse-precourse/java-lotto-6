package lotto.controller.result;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.controller.result.Rank.getRank;

public class winningController {

    public static HashMap<Rank, Integer> createResultRotate(List<Lotto> lottery, WinningNumber winningNumbers, BonusNumber bonus) {
        HashMap<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottery) {
            int resultCount = compareLottoAndWinningNumber(lotto.getLotto(), winningNumbers.getWinningNumbers());
            Rank resultRank = findRank(resultCount, lotto, bonus);
            if (resultRank == null) {
                continue;
            }
            result.put(resultRank, result.getOrDefault(resultRank, 0)+1);
        }
        return result;
    }

    public static Rank findRank(int resultCount, Lotto lotto, BonusNumber bonus) {
        if (resultCount == 5) {
            return checkIfSecondOrThird(lotto, bonus.getBonusNumber());
        }
        return getRank(resultCount);
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

    public static Rank checkIfSecondOrThird(Lotto lotto, int bonus) {
        if (compareLottoAndBonus(lotto.getLotto(), bonus)) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

}
