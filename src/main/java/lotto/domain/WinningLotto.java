package lotto.domain;

import lotto.WinningRank;

import java.util.HashMap;
import java.util.List;

public class WinningLotto extends Lotto {
    private BonusNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, BonusNumber bonusNumber){
        super(numbers);
        bonusNumber.validateDuplicateNumbers(numbers);
    }

    public HashMap<WinningRank, Integer> checkPrize(PurchaseLottos purchaseLottos) {
        HashMap<WinningRank, Integer> winningRankCount = initMap();
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

    private HashMap<WinningRank, Integer> initMap() {
        HashMap<WinningRank, Integer> winningCount = new HashMap<>();
        for(WinningRank winning : WinningRank.values()){
            winningCount.put(winning, 0);
        }
        return winningCount;
    }

}
