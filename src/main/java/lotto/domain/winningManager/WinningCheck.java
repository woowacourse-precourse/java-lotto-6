package lotto.domain.winningManager;

import lotto.domain.lottoDrawMachine.lottoDraw.LottoDraw;
import lotto.domain.vendingMachine.lotto.Lotto;

import java.util.HashMap;
import java.util.List;

public class WinningCheck {
    public HashMap<Integer, Integer> checkRanks(List<Lotto> lottos, LottoDraw lottoDraw) {
        HashMap<Integer, Integer> rankHashMap = new HashMap<Integer, Integer>() {{
            put(5, 0);
            put(4, 0);
            put(3, 0);
            put(2, 0);
            put(1, 0);
            put(0, 0);
        }};

        for (Lotto lotto : lottos) {
            Integer rank = checkRank(lotto, lottoDraw);
            rankHashMap.put(rank, rankHashMap.get(rank) + 1);
        }
        return rankHashMap;
    }

    public Integer checkRank(Lotto lotto, LottoDraw lottoDraw) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = lottoDraw.getWinningNumber();
        Integer bonusNumber = lottoDraw.getBonusNumber();

        int sameNumberCount = calculateSameNumberCount(lottoNumbers, winningNumbers);
        boolean containBonusNumber = isContainBonusNumber(lottoNumbers, bonusNumber);

        return determineRank(sameNumberCount, containBonusNumber);
    }

    private int determineRank(Integer sameNumberCount, Boolean containBonusNumber) {
        if (sameNumberCount == 3) {
            return 5;
        }

        if (sameNumberCount == 4) {
            return 4;
        }

        if (sameNumberCount == 5) {
            if (containBonusNumber) {
                return 2;
            }
            return 3;
        }

        if (sameNumberCount == 6) {
            return 1;
        }

        return 0;
    }

    private int calculateSameNumberCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int sameNumberCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    private boolean isContainBonusNumber(List<Integer> lottoNumbers, Integer bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

}
