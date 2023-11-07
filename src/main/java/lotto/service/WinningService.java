package lotto.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.Lottos;
import lotto.model.WinningNumber;

public class WinningService {

    public Map<Lotto, LottoPrize> checkWinning(Lottos lottos, WinningNumber winningNumber) {
        Map<Lotto, LottoPrize> results = new HashMap<>();

        for(Lotto lotto : lottos.getLottos()) {
            int matches = countMatches(lotto, winningNumber);
            boolean bonusMatch = hasBonusNumber(lotto, winningNumber);
            LottoPrize prize = determinePrize(matches, bonusMatch);

            results.put(lotto, prize);
        }

        return results;
    }

    private int countMatches(Lotto lotto, WinningNumber winningNumber) {
        Set<Integer> lottoNumber = new HashSet<>(lotto.getNumbers());

        lottoNumber.retainAll(winningNumber.getNumbers());
        return lottoNumber.size();
    }

    private boolean hasBonusNumber(Lotto lotto, WinningNumber winningNumber) {
        int bonusNumber = winningNumber.getBonusNumber();

        return lotto.getNumbers().contains(bonusNumber);
    }

    private LottoPrize determinePrize(int matches, boolean bonusMatch) {
        for(LottoPrize prize : LottoPrize.values()) {
            if(prize.getMatchedNumbers() == matches && (!prize.isBonus() || bonusMatch)) {
                return prize;
            }
        }
        return null;
    }
}
