package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    public List<LottoResult> countMatchingNumbers(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int matchingCount = countMatchingNumbersInLotto(lotto, winNumbers);
            boolean isWinner = isWinner(matchingCount);
            WinningResult winningResult = determineWinningResult(matchingCount, isBonusMatch(lottoList, bonusNumber));
            results.add(new LottoResult(isWinner, matchingCount, winningResult));
        }
        return results;
    }

    private int countMatchingNumbersInLotto(Lotto lotto, List<Integer> winNumbers) {
        int count = 0;
        for (int winNumber : winNumbers) {
            if (lotto.contains(winNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean isWinner(int matchingCount) {
        return matchingCount >= 3;
    }

    public WinningResult determineWinningResult(int count, boolean bonusMatch) {
        if (count == 6) {
            return WinningResult.MATCH_6;
        }

        if (count == 5) {
            return bonusMatch ? WinningResult.MATCH_5_WITH_BONUS : WinningResult.MATCH_5;
        }

        if (count == 4) {
            return WinningResult.MATCH_4;
        }

        if (count == 3) {
            return WinningResult.MATCH_3;
        }

        return null;
    }

    public boolean isBonusMatch(List<Lotto> numbers, int bonusNumber) {
        for (Lotto lotto : numbers) {
            if (lotto.contains(bonusNumber)) {
                return true;
            }
        }
        return false;
    }
}
