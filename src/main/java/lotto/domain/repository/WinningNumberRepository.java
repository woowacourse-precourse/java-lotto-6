package lotto.domain.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.WinningNumber;

public class WinningNumberRepository {
    private static List<WinningNumber> winningNumbers = new LinkedList<>();

    public static List<WinningNumber> winningNumbers() {
        return winningNumbers;
    }

    public static void add(WinningNumber winningNumber) {
        winningNumbers.add(winningNumber);
    }

    public static WinningNumber findByIndex(int index) {
        return winningNumbers.get(index);
    }
}
