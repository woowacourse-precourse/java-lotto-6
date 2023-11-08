package lotto.model;

import lotto.constant.ModelConstant;

import java.util.ArrayList;
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

        return comparePrize(matchingNumbers,hasBonus);
    }

    private Prize comparePrize(int matchingNumbers, boolean hasBonus) {
        if(matchingNumbers == ModelConstant.SIX_MATCHING_NUMBER) {
            return Prize.FIRST;
        } else if(matchingNumbers == ModelConstant.FIVE_MATCHING_NUMBER && hasBonus) {
            return Prize.SECOND;
        } else if (matchingNumbers == ModelConstant.FIVE_MATCHING_NUMBER) {
            return Prize.THIRD;
        } else if (matchingNumbers == ModelConstant.FOUR_MATCHING_NUMBER) {
            return Prize.FOURTH;
        } else if (matchingNumbers == ModelConstant.THREE_MATCHING_NUMBER) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    public List<Prize> getRanking() {
        return ranking;
    }

}
