package lotto.domain;

import java.util.List;

public class LottoWinningChecker {
    private static final int BONUS_NUMBER_PARTNER = 5;
    private static final int WINNING_CATEGORY_5_MATCH_WITH_BONUS = 7;

    public static int checkWinningNumbers(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int bonusNumber = winningNumber.getBonusNumber();

        int matchingCount = countMatchingNumbers(lottoNumbers, winningNumbers);

        if (matchingCount == BONUS_NUMBER_PARTNER && lottoNumbers.contains(bonusNumber)) {
            return WINNING_CATEGORY_5_MATCH_WITH_BONUS;
        } else {
            return matchingCount;
        }
    }

    private static int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
