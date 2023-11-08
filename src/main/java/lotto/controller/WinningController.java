package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Winning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.model.Rank.getRank;

public class WinningController {
    public static HashMap<Rank, Integer> createResultRotate(List<Lotto> lottory, Winning winnings, BonusNumber bonus){
        HashMap<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottory) {
            int resultCount = checkWinningNumber(lotto.getNumbers(), winnings.getWinning());
            Rank resultRank = checkRank(resultCount,lotto,bonus);
            if (resultRank == null){
                continue;
            }
            result.put(resultRank,result.getOrDefault(resultRank,0)+1);
        }
        return result;
    }

    public static Rank checkRank(int resultCount, Lotto numbers, BonusNumber bonusNumber){
        if (resultCount == 5){
            return isSecondOrThird(numbers,bonusNumber.getBonusNumber());
        }
        return getRank(resultCount);
    }

    public static int checkWinningNumber(List<Integer> numbers,List<Integer> winning){
        Set<Integer> lottoSet = new HashSet<>(numbers);
        Set<Integer> winningSet = new HashSet<>(winning);
        lottoSet.retainAll(winningSet);
        return lottoSet.size();
    }

    public static boolean checkBonusAndWinning (List<Integer> numbers, int bonusNumber){
        Set<Integer> lottoSet = new HashSet<>(numbers);
        return lottoSet.contains(bonusNumber);
    }

    public static Rank isSecondOrThird(Lotto numbers,int bonusNumber){
        if (checkBonusAndWinning(numbers.getNumbers(), bonusNumber)){
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }
}