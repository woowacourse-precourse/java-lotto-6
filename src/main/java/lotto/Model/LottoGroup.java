package lotto.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Constants.MatchTypes;

public class LottoGroup {
    private List<Lotto> lottoGroup;

    public LottoGroup(List<List<Integer>> lotteryNumbersGroup) {
        this.lottoGroup = new ArrayList<>();
        for (List<Integer> lotteryNumbers : lotteryNumbersGroup) {
            Lotto lotto = new Lotto(lotteryNumbers);
            this.lottoGroup.add(lotto);
        }
    }

    public Map<MatchTypes, Integer> drawLotto(List<Integer> winningNum, Integer bonusWinningNum) {
        Map<MatchTypes, Integer> drawResult = initDrawResult();
        for (Lotto lotto : lottoGroup) {
            Integer numOfMatchedWinningNum = lotto.countWinningMatches(winningNum);
            Integer numOfMatchedBonusWinningNum = lotto.countBonusWinningMatches(bonusWinningNum);
            MatchTypes matchType =
                    MatchTypes.findMatchType(numOfMatchedWinningNum, numOfMatchedBonusWinningNum);
            if (matchType != null) {
                drawResult.put(matchType, drawResult.getOrDefault(matchType, 0) + 1);
            }
        }
        return drawResult;
    }

    private Map<MatchTypes, Integer> initDrawResult() {
        Map<MatchTypes, Integer> initiatedDrawResult = new LinkedHashMap<>();
        for (MatchTypes matchType : MatchTypes.values()) {
            initiatedDrawResult.put(matchType, 0);
        }
        return initiatedDrawResult;
    }

    public List<Lotto> getLottoGroup() {
        return this.lottoGroup;
    }
}
