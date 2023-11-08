package lotto.domain.calculator;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

public class CalculatorMatching {
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