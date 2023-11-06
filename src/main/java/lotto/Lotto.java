package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Validation.MAX_NUMBER;
import static lotto.Validation.MIN_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicates(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다. 다시 입력해 주세요.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45 입니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatches(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean additionalNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
