package lotto.model;

import static lotto.util.Constants.CONFIG_NUMBERS_SIZE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = toNumber(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateOverSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    // TODO: 추가 기능 구현
    private List<Number> toNumber(List<Integer> numbers) {
        return numbers.stream()
            .map(Number::new)
            .toList();
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != CONFIG_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 숫자 6개로 구성됩니다.");
            // String.format("%s에 맞게 입력해주세요", CONFIG_NUMBERS_SIZE)
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != CONFIG_NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복된 수가 존재");
        }
    }
}
