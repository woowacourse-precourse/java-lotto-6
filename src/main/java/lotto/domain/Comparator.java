package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    public static List<WinningCount> compare(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<WinningCount> winningCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int count = countSameNumber(lotto.getNumbers(), winningNumbers);
            boolean hasBonusNumber = checkBonusNumber(lotto.getNumbers(), bonusNumber);
            winningCounts.add(new WinningCount(count, hasBonusNumber));
        }
        return winningCounts;
    }

    private static int countSameNumber(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean checkBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }

}
