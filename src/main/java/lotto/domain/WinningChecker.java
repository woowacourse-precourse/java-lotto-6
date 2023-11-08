package lotto.domain;

import java.util.List;

public class WinningChecker {
    private List<Integer> winningNumbers;

    public WinningChecker(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
    public int checkWinningPrize(int matchingCount, boolean hasBonusNumber) {
        int rank = 0;

        if (matchingCount == 6) {
            rank = Prize.WinningPrize.FIRST_RANK.getPrizeAmount();
        } else if (matchingCount == 5 && hasBonusNumber) {
            rank = Prize.WinningPrize.SECOND_RANK.getPrizeAmount();
        } else if (matchingCount == 5) {
            rank = Prize.WinningPrize.THIRD_RANK.getPrizeAmount();
        } else if (matchingCount == 4) {
            rank = Prize.WinningPrize.FOURTH_RANK.getPrizeAmount();
        } else if (matchingCount == 3) {
            rank = Prize.WinningPrize.FIFTH_RANK.getPrizeAmount();
        }

        return rank;
    }

    public int checkMachingCount(List<Integer> numbers) {
        int machingCount = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                machingCount++;
            }
        }
        return machingCount;
    }

    public boolean hasBonusNumber(BonusNumber bonusNumber, List<Integer> numbers) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

}
