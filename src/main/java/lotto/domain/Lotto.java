package lotto.domain;

import static lotto.domain.LottoValue.LOTTO_RANGE_IN_END_VALUE;
import static lotto.domain.LottoValue.LOTTO_RANGE_IN_START_VALUE;
import static lotto.domain.LottoValue.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueElements(numbers, uniqueNumberSet(numbers));
        validationInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
    }

    private void validateUniqueElements(List<Integer> numbers, HashSet<Integer> uniqueNumberSet) {
        if (numbers.size() != uniqueNumberSet.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 값은 중복을 허용하지 않습니다.");
        }
    }

    private HashSet<Integer> uniqueNumberSet(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }

    public void validationInRange(List<Integer> lotto) {
        if (!lotto.stream().allMatch(this::range)) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 값은 1이상 45이하의 값만 가능합니다.");
        }
    }

    private boolean range(Integer number) {
        return LOTTO_RANGE_IN_START_VALUE <= number
                && number <= LOTTO_RANGE_IN_END_VALUE;
    }

}
