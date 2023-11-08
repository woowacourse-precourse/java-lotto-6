package lotto.domain.calculator;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class CalculatorMatching {
    public List<Rank> calculateRanks(List<Lotto> tickets, WinningNumber winningNumber, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto ticket : tickets) {
            Rank rank = calculateRank(ticket, winningNumber, bonusNumber);
            ranks.add(rank);
        }
        return ranks;
    }

    private Rank calculateRank(Lotto ticket, WinningNumber winningNumber, int bonusNumber) {
        int matchingNumbers = countMatchingNumbers(ticket, winningNumber);
        boolean hasBonusNumber = ticket.getNumbers().contains(bonusNumber);

        if (matchingNumbers == 6) {
            return Rank.FIRST;
        } else if (matchingNumbers == 5 && hasBonusNumber) {
            return Rank.SECOND;
        } else if (matchingNumbers == 5) {
            return Rank.THIRD;
        } else if (matchingNumbers == 4) {
            return Rank.FOURTH;
        } else if (matchingNumbers == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    private int countMatchingNumbers(Lotto ticket, WinningNumber winningNumber) {
        int count = 0;
        for (int number : ticket.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }
}