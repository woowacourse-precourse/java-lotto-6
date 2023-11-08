package lotto.Model;

import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER =1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numberRangeCheck(numbers);
        numberDuplicateCheck(numbers);
        numberLengthCheck(numbers);
    }

    private void numberLengthCheck(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_SIZE.getErrorMessage());
        }
    }
    private void numberRangeCheck(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getErrorMessage());
        }
    }

    private static void numberDuplicateCheck(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_DUPLICATION.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
