package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoResultAnalyzer {

    public static List<Integer> calculateWinnings(List<Lotto> lotto, Set<Integer> winningNumbers, int bonusNumber) {
        List<Integer> winnings = new ArrayList<>(Collections.nCopies(5, 0));

        for (Lotto ticket : lotto) {
            boolean hasBonusNumber = false;

            int matchedNumbers = countMatchingNumbers(ticket, winningNumbers);
            if (matchedNumbers == 5) {
                hasBonusNumber = ticket.getNumbers().contains(bonusNumber);
            }

            int rank = calculateRank(matchedNumbers, hasBonusNumber);
            if (rank > 0) {
                int indexToIncrease = 5 - rank;
                int currentValue = winnings.get(indexToIncrease);
                winnings.set(indexToIncrease, currentValue + 1);
            }
        }
        return winnings;
    }

    public static int countMatchingNumbers(Lotto ticket, Set<Integer> winningNumbers) {
        int matchedNumbers = 0;
        for (Integer number : ticket.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchedNumbers++;
            }
        }
        return matchedNumbers;
    }

    public static int calculateRank(int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 6) {
            return 1;
        } else if (matchedNumbers == 5 && hasBonusNumber) {
            return 2;
        } else if (matchedNumbers == 5) {
            return 3;
        } else if (matchedNumbers == 4) {
            return 4;
        } else if (matchedNumbers == 3) {
            return 5;
        }
        return 0; // No winnings
    }

}