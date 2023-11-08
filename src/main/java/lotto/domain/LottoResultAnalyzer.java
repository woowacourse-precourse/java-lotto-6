package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoResultAnalyzer {

    public static List<Integer> calculateWinnings(List<Lotto> lotto, Set<Integer> winningNumbers, int bonusNumber) {
        List<Integer> winnings = new ArrayList<>(Collections.nCopies(5, 0));

        for (Lotto ticket : lotto) {
            int matchedNumbers = countMatchingNumbers(ticket, winningNumbers);
            boolean hasBonusNumber = checkBonusNumber(matchedNumbers, bonusNumber, ticket);

            int rank = calculateRank(matchedNumbers, hasBonusNumber);
            updateWinnings(winnings, rank);
        }
        return winnings;
    }


    private static boolean checkBonusNumber(int matchedNumbers, int bonusNumber, Lotto ticket) {
        boolean hasBonusNumber = false;
        if (matchedNumbers == 5) {
            hasBonusNumber = ticket.getNumbers().contains(bonusNumber);
        }
        return hasBonusNumber;
    }

    private static void updateWinnings(List<Integer> winnings, int rank) {
        if (rank > 0) {
            int indexToIncrease = 5 - rank;
            int currentValue = winnings.get(indexToIncrease);
            winnings.set(indexToIncrease, currentValue + 1);
        }
    }
    private static int countMatchingNumbers(Lotto ticket, Set<Integer> winningNumbers) {
        int matchedNumbers = 0;
        for (Integer number : ticket.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchedNumbers++;
            }
        }
        return matchedNumbers;
    }

    private static int calculateRank(int matchedNumbers, boolean hasBonusNumber) {
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