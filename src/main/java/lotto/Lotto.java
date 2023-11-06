package lotto;

import lotto.Util.ErrorMessage;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE=6;
    public static final int MIN_LOTTO_RANGE=1;
    public static final int MAX_LOTTO_RANGE=45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers=sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        validateNumberSize(numbers);
        validateNumberRange(numbers);
        validateNumber_NotEqual(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_RANGE || number > MAX_LOTTO_RANGE) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }


    private void validateNumber_NotEqual(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                checkNotEqual(numbers.get(i), numbers.get(j));
            }
        }
    }

    private void checkNotEqual(Integer number1,Integer number2) {
        if (number1.equals(number2)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    // TODO: 추가 기능 구현
}
