package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Value;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public static List<Integer> checkFormat(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Value.LOTTO_NUMBER_COUNT.get()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_OF_LOTTO.get());
        }
        numbers.forEach(Lotto::checkRange);
        return numbers;
    }

    public static int checkRange(int number) throws IllegalArgumentException {
        if (number < Value.START_NUMBER.get() || number > Value.END_NUMBER.get()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE.get());
        }
        return number;
    }
}