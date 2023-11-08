package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRepeated(numbers);
        List<Integer> sortedNumbers = sortNumbers(numbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 수는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateRepeated(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 중복되지 않아야 합니다.");
        }
    }
    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}