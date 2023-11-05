package lotto.domain;

public class Comparator {
    public static int countSameNumber(Lotto numbers, Lotto winnerNumbers) {
        return (int) numbers.getNumbers().stream()
                .filter(number -> winnerNumbers.getNumbers().contains(number))
                .count();
    }
}
