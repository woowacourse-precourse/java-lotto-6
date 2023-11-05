package lotto.domain;

public class Comparator {
    public static int countSameNumber(Lotto numbers, Lotto winnerNumbers) {
        return (int) numbers.getNumbers().stream()
                .filter(number -> winnerNumbers.getNumbers().contains(number))
                .count();
    }

    public static boolean checkBonusNumber(Lotto numbers, int bonusNumber) {
        return numbers.getNumbers().stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
