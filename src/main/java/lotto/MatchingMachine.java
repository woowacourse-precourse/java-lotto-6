package lotto;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MatchingMachine {

    public int countSingleLottoMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        for (int lottoNum : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(lottoNum)) {
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

    public List<MatchingCount> countAllLottoMatchingNumbers(List<Lotto> allLotto, Lotto winningLotto, int bonusNumber) {
        int count = 0;
        boolean hasBonus = false;
        List<MatchingCount> matchingCounts = new ArrayList<>();
        for (Lotto singleLotto : allLotto) {
            count = countSingleLottoMatchingNumbers(singleLotto, winningLotto);
            hasBonus = checkBonusNumber(singleLotto, bonusNumber);
            MatchingCount matchingCount = MatchingCount.findByMatchCount(count, hasBonus);
            if(matchingCount != null) {
                matchingCounts.add(matchingCount);
            }
        }
        return matchingCounts;
    }

    public void getResultAsConsole(List<MatchingCount> matchingCounts){
        System.out.println("\n당첨 통계 \n ---");
        Map<MatchingCount, Integer> map = getLottoResultAsMap(matchingCounts);
        System.out.println("3개 일치 (5,000원) - " +map.get(MatchingCount.THREE) +"개");
        System.out.println("4개 일치 (50,000원) - " +map.get(MatchingCount.FOUR) +"개");
        System.out.println("5개 일치 (1,500,000원) - " +map.get(MatchingCount.FIVE) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +map.get(MatchingCount.FIVE_BONUS) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " +map.get(MatchingCount.SIX) +"개");
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
