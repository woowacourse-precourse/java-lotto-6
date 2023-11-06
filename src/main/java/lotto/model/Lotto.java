package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessageType.ERROR_DUPLICATE_LOTTO_NUMBER;
import static lotto.common.ErrorMessageType.ERROR_INVALID_LOTTO_SIZE;

/**
 * @Class : 로또 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_SIZE.getLottoMessage());
        }
        List<Integer> distinctList = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_LOTTO_NUMBER.getLottoMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
