package lotto.utils;

import lotto.domain.Result;

import java.util.List;

public class DefaultLottoWinningStrategy implements LottoWinningStrategy {

    private static final int DEFAULT_COUNT = 0;

    @Override
    public Result determineResult(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusBall) {
        int matchCount = getMatchCount(lottoNumbers, winningNumbers);
        boolean bonusMatch = getBonusMatch(lottoNumbers, bonusBall);

        return new Result(matchCount, bonusMatch);
    }
    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = DEFAULT_COUNT;

        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean getBonusMatch(List<Integer> lottoNumbers, int bonusNumber) {
        boolean bonusMatch = false;

        if (lottoNumbers.contains(bonusNumber)) {
            bonusMatch = true;
        }
        return bonusMatch;
    }
}
