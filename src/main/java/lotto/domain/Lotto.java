package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCountOfNumbers(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueElements = new HashSet<>(numbers);
        if (numbers.size() !=uniqueElements.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    public Ranking getRanking(List<Integer> winningNumbers, int bonusNumber) {
        int matchNumber = (int) numbers.stream().filter(n -> winningNumbers.contains(n)).count();
        for (Ranking ranking : Ranking.values()) {
            if (ranking.getMatchNumber() == matchNumber && ranking.isMatchBonus() == numbers.contains(bonusNumber)) {
                return ranking;
            }
        }
        return Ranking.NONE;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
