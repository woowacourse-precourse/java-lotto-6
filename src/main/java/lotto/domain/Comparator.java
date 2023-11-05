package lotto.domain;

public class Comparator {
    public int countSameNumber(Lotto lotto, Lotto winnerNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winnerNumbers.getNumbers().contains(number))
                .count();
    }

    public boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
