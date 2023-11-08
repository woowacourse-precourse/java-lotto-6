package lotto;

import java.util.*;

public class LottoWinMap {

    public Map<String, Integer> howManyEquals(ArrayList<List<Integer>> lottoNumbers,
                                 List<Integer> winNumbers, int bonusNumber) {
        Map<String, Integer> equalsCount = new HashMap<>();
        equalsCount.put("3개 일치", 0);
        equalsCount.put("4개 일치", 0);
        equalsCount.put("5개 일치", 0);
        equalsCount.put("5개 일치, 보너스 볼 일치", 0);
        equalsCount.put("6개 일치", 0);
        for(List<Integer> lotto : lottoNumbers) {
            Set<Integer> intersection = new HashSet<>(winNumbers);
            Set<Integer> lottoNumber = new HashSet<>(lotto);
            intersection.retainAll(lottoNumber);
            int equalsCnt = intersection.size();
            if(equalsCnt == 0 || equalsCnt == 1 || equalsCnt == 2) {
                continue;
            }
            if(equalsCnt == 5 && lotto.contains(bonusNumber)) {
                equalsCount.put("5개 일치, 보너스 볼 일치", equalsCount.get("5개 일치, 보너스 볼 일치") + 1);
                continue;
            }
            equalsCount.put(equalsCnt+"개 일치", equalsCount.get(equalsCnt+"개 일치") + 1);
        }
        return equalsCount;
    }
}
