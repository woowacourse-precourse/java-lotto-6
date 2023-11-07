package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;

public class CheckResultService {
    public int matchResult(List<Integer> lotto, List<Integer> winLottoNumber) {
        int matched = 0;
        for (int i : lotto) {
            if (winLottoNumber.contains(i)) {
                matched++;
            }
        }
        return matched;
    }

    public boolean inWinRange(int matched) {
        if (LottoPrize.THREE_MATCH.getMatchedNumber() <= matched
                && matched <= LottoPrize.SIX_MATCH.getMatchedNumber()) {
            return true;
        }
        return false;
    }

    public boolean isBonusNumberIncluded(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public int calculateEarning(Map<LottoPrize, Integer> lottoResult) {
        int earn = 0;
        for (LottoPrize lottoPrize : lottoResult.keySet()) {
            earn += lottoPrize.getPrize() * lottoResult.get(lottoPrize);
        }
        return earn;
    }


}
