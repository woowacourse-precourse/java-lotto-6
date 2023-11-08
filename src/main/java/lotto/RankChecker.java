package lotto;

import java.util.List;

public class RankChecker {
    private final Lotto winningNumbers;
    private final Number bonusNumber;

    public RankChecker(Lotto winningNumbers, Number bonusNumber) {
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

        if (bonusNumber.isContainedIn(ticketNumbers)) {
            countForMatchingBonusNumbers++;
        }

        return Rank.calculateRank(countForMatchingWinningNumbers, countForMatchingBonusNumbers);
    }
}
