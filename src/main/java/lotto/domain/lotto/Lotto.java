package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    private static final String NUMBERS_SIZE_ERROR_MESSAGE = "로또 번호는 6개이어야 합니다.";
    private static final String NUMBERS_DUPLICATE_ERROR_MESSAGE = "로또 번호에 중복이 있으면 안됩니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 1~45 의 숫자입니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;
    static final int LOTTO_MIN_NUMBER = 1;
    static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    Lotto(Lotto lotto) {
        this.numbers = lotto.numbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        numbersSizeValidation(numbers);
        numbersDuplicateValidation(numbers);
        numbersRangeValidation(numbers);
    }

    private void numbersSizeValidation(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void numbersDuplicateValidation(List<Integer> numbers) {
        long count = numbers.stream().distinct()
                .count();
        if (count != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void numbersRangeValidation(List<Integer> numbers) {
        numbers.forEach(this::checkNumberInRange);
    }

    private void checkNumberInRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    int compareLottoNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
