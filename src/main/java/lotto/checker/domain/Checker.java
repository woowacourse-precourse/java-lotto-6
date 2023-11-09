package lotto.checker.domain;

import java.util.List;

public class Checker {

    private static final Integer BONUS_INDEX = 6;

    public static Integer calculateRank(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        Integer matchedCount = 0;
        Integer bonusMatched = 0;
        lottoNumbers.retainAll(winningNumbers);
        matchedCount = lottoNumbers.size();
        if (lottoNumbers.contains(winningNumbers.get(BONUS_INDEX))) {
            matchedCount -= 1;
            bonusMatched = 1;
        }
        return convertRank(matchedCount, bonusMatched);
    }

    public static Integer convertRank(Integer matchedCount, Integer bonusMatched) {
        if (matchedCount == 3) {
            return 5;
        } else if (matchedCount == 4) {
            return 4;
        } else if (matchedCount == 5 && bonusMatched == 0) {
            return 3;
        } else if (matchedCount == 5 && bonusMatched == 1) {
            return 2;
        } else if (matchedCount == 6) {
            return 1;
        }
        return 6;
    }

}
