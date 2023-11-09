package lotto.domain.lotto;

import static lotto.constant.ExceptionMessage.ENTER_CORRECT_RANGE_NUMBER;
import static lotto.constant.ExceptionMessage.ENTER_NOT_DUPLICATION_NUMBER;
import static lotto.constant.ExceptionMessage.ENTER_SIX_NUMBER;
import static lotto.constant.LottoNumber.LOTTO_SIZE;
import static lotto.constant.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.MIN_LOTTO_NUMBER;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int compare(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return (int) IntStream.range(0, LOTTO_SIZE.getNumber())
                .filter(i -> this.numbers.contains(numbers.get(i)))
                .count();
    }

    private void validate(List<Integer> numbers) {
        checkListSize(numbers);
        checkNumberRange(numbers);
        checkDuplication(numbers);
    }

    private void checkListSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(ENTER_SIX_NUMBER.getMessage());
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number > MAX_LOTTO_NUMBER.getNumber() || number < MIN_LOTTO_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ENTER_CORRECT_RANGE_NUMBER.getMessage());
            }
        });
    }

    private void checkDuplication(List<Integer> numbers) {
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != count) {
            throw new IllegalArgumentException(ENTER_NOT_DUPLICATION_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
