package lotto;

import java.util.List;

public class RankChecker {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public RankChecker(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank check(Lotto lottoTicket) {
        List<Integer> ticketNumbers = lottoTicket.getNumbers();
        List<Integer> winningNumbersList = winningNumbers.getNumbers();

        int countForMatchingWinningNumbers = 0;
        int countForMatchingBonusNumbers = 0;

        for (int ticketNumber : ticketNumbers) {
            if (winningNumbersList.contains(ticketNumber)) {
                countForMatchingWinningNumbers++;
            }
        }

        if (ticketNumbers.contains(bonusNumber)) {
            countForMatchingBonusNumbers++;
        }

        return Rank.calculateRank(countForMatchingWinningNumbers, countForMatchingBonusNumbers);
    }
}
