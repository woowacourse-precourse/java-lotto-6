package lotto.domain;

import java.util.List;

public class LottoChecker {
    private static final int SECOND_PLACE_MATCHING_NUMBER = 5;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Ranking checkOneLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int matchingCount = 0;
        for (Integer number : lottoNumbers) {
            matchingCount += isMatchingNumber(number);
        }
        boolean isContainBonus = isBonusMatch(lottoNumbers);

        return rankingResult(matchingCount, isContainBonus);
    }

    private int isMatchingNumber(int number) {
        if (winningNumbers.contains(number) || number == bonusNumber) {
            return 1;
        }
        return 0;
    }

    private boolean isBonusMatch(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    private Ranking rankingResult(int matchingNumbers, boolean isContainBonus) {
        Ranking ranking = Ranking.getRanking(matchingNumbers);
        if (isContainBonus && matchingNumbers == SECOND_PLACE_MATCHING_NUMBER) {
            ranking = Ranking.SECOND_PLACE;
        }
        return ranking;
    }
}
