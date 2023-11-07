package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrizeResult {

    List<Prize> ranking = new ArrayList<>();

    public PrizeResult(List<Integer> lottoMatch, List<Boolean> hasBonusMatch) {
        calculatePrizeRanking(lottoMatch,hasBonusMatch);
    }

    private void calculatePrizeRanking(List<Integer> lottoMatch, List<Boolean> hasBonusMatch) {
        for (int i=0; i<lottoMatch.size(); i++) {
          ranking.add(setRankingList(lottoMatch,hasBonusMatch, i));
        }
    }

    private Prize setRankingList(List<Integer> lottoMatch, List<Boolean> hasBonusMatch, int index) {
        int matchingNumbers = lottoMatch.get(index);
        boolean hasBonus = hasBonusMatch.get(index);

        if(matchingNumbers == 6) {
            return Prize.FIRST;
        } else if(matchingNumbers == 5 && hasBonus) {
            return Prize.SECOND;
        } else if (matchingNumbers == 5) {
            return Prize.THIRD;
        } else if (matchingNumbers == 4) {
            return Prize.FOURTH;
        } else if (matchingNumbers == 3) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    public List<Prize> getRanking() {
        return ranking;
    }
}
