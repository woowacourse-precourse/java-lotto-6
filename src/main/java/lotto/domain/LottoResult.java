package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static Map<LottoRanking, Integer> getResults(Lotto lotto, List<Lotto> lottos, Bonus bonus){
        Map<LottoRanking, Integer> results = new HashMap<>();
        initializeResultMap(results);
        for(Lotto playerLotto : lottos){
            Integer countAboutLotto = getCountAboutLotto(lotto, playerLotto);
            Boolean isMatchBonus = getIsMatchBonus(lotto, bonus);
            LottoRanking ranking = LottoRanking.getRanking(countAboutLotto, isMatchBonus);
            results.put(ranking, results.get(ranking)+1);
        }
        return results;
    }

    private static void initializeResultMap(Map<LottoRanking, Integer> results){
        for(LottoRanking ranking : LottoRanking.values()){
            results.put(ranking, 0);
        }
    }

    private static Integer getCountAboutLotto(Lotto winningLotto, Lotto playerLotto){
        return winningLotto.countMatchedOtherLotto(playerLotto);
    }

    private static Boolean getIsMatchBonus(Lotto winningLotto, Bonus bonus){
        return winningLotto.isContainBonus(bonus);
    }
}
