package lotto.domain;

import java.util.List;

public class LottoWinningChecker {
    private static final int BONUS_NUMBER_PARTNER = 5;
    private static final int FIVE_MATCH_WITH_BONUS = 7;
    private static final int LAST_INDEX_OF_MATCH_COUNT = 8;

    public static int checkWinningNumbers(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int bonusNumber = winningNumber.getBonusNumber();

        int matchingCount = countMatchingNumbers(lottoNumbers, winningNumbers);

        if (matchingCount == BONUS_NUMBER_PARTNER && lottoNumbers.contains(bonusNumber)) {
            return FIVE_MATCH_WITH_BONUS;
        }

        return matchingCount;
    }

    public static int[] calculateMatchCounts(List<Lotto> lottos, WinningNumber winningNumber) {
        int[] matchCounts = new int[LAST_INDEX_OF_MATCH_COUNT];

        for (Lotto lotto : lottos) {
            int matchingCount = LottoWinningChecker.checkWinningNumbers(lotto, winningNumber);
            matchCounts[matchingCount]++;
        }

        return matchCounts;
    }

    private static int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static long calculateTotalPrize(List<Lotto> lottos, WinningNumber winningNumber) {
        int[] matchCounts = calculateMatchCounts(lottos, winningNumber);

        long totalPrize = 0;

        for (int i = Prize.THIRD_MATCH.getMatchingCount(); i <= Prize.FIFTH_AND_BONUS_MATCH.getMatchingCount(); i++) {
            totalPrize += matchCounts[i] * Prize.values()[i - Prize.THIRD_MATCH.getMatchingCount()].getPrizeAmount();
        }

        return totalPrize;
    }
}
