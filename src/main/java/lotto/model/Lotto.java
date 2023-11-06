package lotto.model;

import java.util.List;
import lotto.constant.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLengthCheck(numbers);
        validateDuplicateNumber(numbers);
        validateNumbers(numbers);
    }

    private void validateLengthCheck(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호의 갯수 %d개를 만족해야합니다.", LottoConstant.SIZE));
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (getDistinctCount(numbers) != LottoConstant.SIZE) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        numbers.forEach(this::validateProperNumber);
    }

    private void validateProperNumber(Integer number) {
        if (number < LottoConstant.MIN_NUMBER || number > LottoConstant.MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "숫자는 %d에서 %d사이여야합니다."
                    , LottoConstant.MIN_NUMBER
                    , LottoConstant.MAX_NUMBER
                )
            );
        }
    }

    private int getDistinctCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }

    public List<Integer> getSortedNumbers() {
        return this.numbers
                .stream()
                .sorted()
                .toList();
    }
}
