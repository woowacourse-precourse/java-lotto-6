package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGroup {
    private List<Lotto> lottoGroup;

    public LottoGroup(List<List<Integer>> lotteryNumbersGroup){
        for(List<Integer> lotteryNumbers : lotteryNumbersGroup){
            Lotto lotto = new Lotto(lotteryNumbers);
            this.lottoGroup.add(lotto);
        }
    }

    public List<Map<String, Integer>> drawLotto(List<Integer> winningNum, Integer bonusWinningNum){
        List<Map<String, Integer>> drawResults = new ArrayList<>();
        Map<String, Integer> resultOfEachLotto = new HashMap<>();
        for(Lotto lotto : lottoGroup){
            Integer matchCount = lotto.countWinningMatches(winningNum);
            Integer bonusMatchCount = lotto.countBonusWinningMatches(bonusWinningNum);
            resultOfEachLotto.put("matchCount", matchCount);
            resultOfEachLotto.put("hasBonusMatch", bonusMatchCount);
            drawResults.add(resultOfEachLotto);
        }

        return drawResults;
    }
    public List<Lotto> getLottoGroup(){
        return this.lottoGroup;
    }
}
