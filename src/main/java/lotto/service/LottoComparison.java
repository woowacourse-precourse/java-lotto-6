package lotto.service;

import static lotto.domain.Ranking.SECOND;
import static lotto.domain.Ranking.NONE;

import java.util.List;
import lotto.domain.Ranking;

public class LottoComparison {
    public long compareLottoNumbers(List<Integer> lotto, List<Integer> winningNumbers){
        return lotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean compareBonusNumber(List<Integer> lotto, int bonusNumber){
        for(int number: lotto){
            if(number == bonusNumber)
                return true;
        }
        return false;
    }

    public static Ranking determineRanking(long matchCount, boolean isBonus) {
        for (Ranking ranking : Ranking.values()) {
            if (matchCount == 5 && isBonus) {
                return SECOND;
            }
            if(ranking.getMatchNumber() == matchCount){
                return ranking;
            }
        }
        return NONE;
    }
}
