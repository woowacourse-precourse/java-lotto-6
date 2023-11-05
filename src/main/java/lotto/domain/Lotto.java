package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateSameItem(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(i -> 1 <= i && i <= 45)){
            throw new IllegalArgumentException("1~45사이의 값만 입력해주세요.");
        }
    }

    private void validateSameItem(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("중복된 값을 입력하지 마세요.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요");
        }
    }

}
