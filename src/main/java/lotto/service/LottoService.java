package lotto.service;

import lotto.model.Lotto;

import java.util.HashMap;
import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_WIN_SECOND;
import static lotto.constant.LottoConstant.LOTTO_WIN_THIRD;

public class LottoService {

    public HashMap<Integer, Integer> calculateWinningResult(List<List<Integer>> randomSixNumbers, Lotto lotto, int bonusNumber) {
        HashMap<Integer, Integer> winningResult = new HashMap<>(0);
        for (List<Integer> randomSixNumber : randomSixNumbers) {
            int matchingCount = winningCount(randomSixNumber, lotto.getNumbers());
            boolean hasBonus = winningBonusNumber(randomSixNumber, bonusNumber);
            if (!hasBonus) {
                winningResult.put(matchingCount, winningResult.getOrDefault(matchingCount, 0) + 1);
            }
            if (hasBonus && matchingCount == LOTTO_WIN_THIRD) {
                winningResult.put(matchingCount + 2, winningResult.getOrDefault(LOTTO_WIN_SECOND, 0) + 1);
            }
        }
        return winningResult;
    }

    private int winningCount(List<Integer> randomSixNumber, List<Integer> correctNumber) {
        int count = 0;
        for (Integer correct : correctNumber) {
            if (randomSixNumber.contains(correct)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean winningBonusNumber(List<Integer> randomSixNumber, int bonusNumber) {
        if (randomSixNumber.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
