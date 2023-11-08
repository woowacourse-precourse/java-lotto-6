package lotto.domain;

import lotto.WinningRank;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto extends Lotto {
    private final BonusNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, BonusNumber bonusNumber){
        super(numbers);
        bonusNumber.validateDuplicateNumbers(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningRank, Integer> checkPrize(PurchaseLottos purchaseLottos) {
        Map<WinningRank, Integer> winningRankCount = initMap();
        List<List<Integer>> lottoNumbers = purchaseLottos.geBuyingLottoNumbers();
        for(List<Integer> numbers : lottoNumbers){
            int matchCount = this.compareLottoNumbers(numbers);
            boolean matchedBonusNumber = false;
            if(matchCount == 5) matchedBonusNumber = bonusNumber.isMatchingBonusNumber(numbers);
            WinningRank winningRank = WinningRank.findWinningRank(matchCount, matchedBonusNumber);
            winningRankCount.put(winningRank, winningRankCount.get(winningRank) + 1);
        }
        return winningRankCount;
    }

    private Map<WinningRank, Integer> initMap() {
        Map<WinningRank, Integer> winningCount = new LinkedHashMap<>();
        for(WinningRank winning : WinningRank.values()){
            winningCount.put(winning, 0);
        }
        return winningCount;
    }

}
