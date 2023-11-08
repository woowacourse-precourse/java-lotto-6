package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import lotto.LottoEnum.Prize;

public class NumberComparing {
    private final int SIZEOFLOTTONUMBERS = 6;

    private final List<Integer> winningNumbers;
    private final int bonusWinningNumber;

    public NumberComparing(List<Integer> winningNumbers, int bonusWinningNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusWinningNumber = bonusWinningNumber;
    }

    public int getNumberOfMatch(Lotto lotto) {
        HashSet<Integer> lottoNumberBundle = new HashSet<>(lotto.getNumbers());
        HashSet<Integer> winningNumbersBundle = new HashSet<>(winningNumbers);

        lottoNumberBundle.retainAll(winningNumbersBundle);

        int result = SIZEOFLOTTONUMBERS - lottoNumberBundle.size();

        return result;
    }

    public Boolean isMatchBonusWinningNumber(Lotto lotto) {
        HashSet<Integer> lottoNumberBundle = new HashSet<>(lotto.getNumbers());

        Boolean result = lottoNumberBundle.contains(bonusWinningNumber);

        return result;
    }

    public Prize getPrizeResult(int numberOfMatch, Boolean isMatchBonusWinningNumber) {
        if (numberOfMatch == 6) {
            return Prize.FIRST;
        } else if (numberOfMatch == 5 && isMatchBonusWinningNumber) {
            return Prize.SECOND;
        } else if (numberOfMatch == 5) {
            return Prize.THIRD;
        } else if (numberOfMatch == 4) {
            return Prize.FOURTH;
        } else if (numberOfMatch == 3) {
            return Prize.FIFTH;
        }

        return Prize.LOSE;
    }

    public List<Prize> getPrizeResults(List<Lotto> lottos) {
        List<Prize> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int numberOfMatch = getNumberOfMatch(lotto);
            Boolean isMatchBonusWinningNumber = isMatchBonusWinningNumber(lotto);

            results.add(getPrizeResult(numberOfMatch, isMatchBonusWinningNumber));
        }

        return results;
    }
}
