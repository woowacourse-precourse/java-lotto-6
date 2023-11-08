package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = new ArrayList<>(numbers); // ArrayList로 복사
        Collections.sort(this.numbers); // 정렬
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("사이즈 초과");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("중복된 값 발견: " + number);
            }
            uniqueNumbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
