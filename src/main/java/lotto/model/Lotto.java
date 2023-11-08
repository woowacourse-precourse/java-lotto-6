package lotto.model;

import static lotto.constants.ErrorMessage.ALREADY_USED_NUMBER_NOT_ALLOWED;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_SIZE_SIX_ALLOWED;
import static lotto.constants.ErrorMessage.LOTTO_RANGE_NUMBER_ALLOWED;
import static lotto.constants.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoNumber.LOTTO_MIN_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNotDuplicated(numbers);
        validateNumbersInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_SIX_ALLOWED.toString());
        }
    }

    // TODO: 추가 기능 구현
    private void validateNotDuplicated(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(ALREADY_USED_NUMBER_NOT_ALLOWED.toString());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberInRange);
    }

    private void validateNumberInRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_RANGE_NUMBER_ALLOWED.toString());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer countMatchNumber(Lotto lotto) {
        List<Integer> copyOfLotto = new ArrayList<>(lotto.getNumbers());
        copyOfLotto.retainAll(numbers);
        return copyOfLotto.size();
    }

    public Boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }
}
