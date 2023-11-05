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
        if (notInRange(numbers)) {
            throw new IllegalArgumentException("1~45사이의 값만 입력해주세요.");
        }
    }

    private static boolean notInRange(List<Integer> numbers) {
        return !numbers.stream().allMatch(LottoConstraint::inRange);
    }

    private void validateSameItem(List<Integer> numbers) {
        if (hasSameItem(numbers)) {
            throw new IllegalArgumentException("중복된 값을 입력하지 마세요.");
        }
    }

    private static boolean hasSameItem(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private void validateSize(List<Integer> numbers) {
        if (isUnsuitableSize(numbers)) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요");
        }
    }

    private static boolean isUnsuitableSize(List<Integer> numbers) {
        return !LottoConstraint.checkSize(numbers.size());
    }

}
