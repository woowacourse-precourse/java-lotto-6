package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class MatchingMachine {

    public int countSingleLottoMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int lottoNum : lottoNumbers) {
            if (winningNumbers.contains(lottoNum)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> singleLotto = lotto.getNumbers();
        if (singleLotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public List<MatchingCount> countAllLottoMatchingNumbers(List<Lotto> allLotto, List<Integer> winningNumbers, int bonusNumber) {
        int count = 0;
        boolean hasBonus = false;
        List<MatchingCount> matchingCounts = new ArrayList<>();
        for (Lotto singleLotto : allLotto) {
            count = countSingleLottoMatchingNumbers(singleLotto.getNumbers(), winningNumbers);
            hasBonus = checkBonusNumber(singleLotto, bonusNumber);
            MatchingCount matchingCount = MatchingCount.findByMatchCount(count, hasBonus);
            if(matchingCount != null) {
                matchingCounts.add(matchingCount);
            }
        }
        return matchingCounts;
    }

    public Map<MatchingCount, Integer> getLottoResultAsMap(List<MatchingCount> allMatchingCount){
        Map<MatchingCount, Integer> map = new HashMap<>();
        map.put(MatchingCount.THREE,0);
        map.put(MatchingCount.FOUR,0);
        map.put(MatchingCount.FIVE,0);
        map.put(MatchingCount.FIVE_BONUS,0);
        map.put(MatchingCount.SIX,0);
        for(MatchingCount matchingCount : allMatchingCount){
            int count = map.get(matchingCount);
            map.put(matchingCount, count+1);
        }
        return map;
    }
}
