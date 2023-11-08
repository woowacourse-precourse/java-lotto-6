package lotto.domain;


import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    /* 상수 */
    private final Integer LOTTO_SIZE = 6;
    private final String MSG_LOTTO_SIZE_ERROR = "로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.";
    private final String MSG_DUPLICATED_NUMBERS_ERROR = "로또 번호에 중복된 숫자가 있으면 예외가 발생한다.";
    private final String MSG_SORTED_NUMBERS_ERROR = "로또 번호가 정렬 되어 있지 않으면 예외가 발생한다.";
    private final String MSG_NUMBER_RANGE_ERROR = "로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.";
    private enum NumberRange {
        MINIMUM(1),
        MAXIMUM(45);

        private final Integer value;

        NumberRange(int value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicatedNumbers(numbers);
        validateSortedNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(MSG_LOTTO_SIZE_ERROR);
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(MSG_DUPLICATED_NUMBERS_ERROR);
        }
    }

    private void validateSortedNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            Integer currentNum = numbers.get(i);
            Integer nextNum = numbers.get(i + 1);

            if (currentNum > nextNum) {
                throw new IllegalArgumentException(MSG_SORTED_NUMBERS_ERROR);
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < NumberRange.MINIMUM.getValue()
                    || number > NumberRange.MAXIMUM.getValue()) {
                throw new IllegalArgumentException(MSG_NUMBER_RANGE_ERROR);
            }
        }
    }
}
