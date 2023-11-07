package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
    }
    public void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6자리가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }
    public void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumberInLotto(int Number) {
        return numbers.contains(Number);
    }
    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }
}
