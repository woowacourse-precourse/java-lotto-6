package lotto;

import java.util.List;

public class Lotto {
    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 45;
    static int NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateAuthorizedLength(numbers);
        validateDuplicatedNums(numbers);
        validateProperNumbers(numbers);
    }

    public void validateAuthorizedLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.BOUND_LENGTH.getErrorMessage());
        }
    }

    public void validateProperNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int lottoNum = numbers.get(i);
            if (lottoNum > MIN_NUMBER && lottoNum < MAX_NUMBER) {
                throw new IllegalArgumentException(
                        ErrorMessage.NON_PROPER_NUMS.getErrorMessage()
                );
            }
        }
    }

    public void validateDuplicatedNums(List<Integer> numbers) {
        int distinctNumbersCount = (int) numbers.stream().distinct().count();
        if (distinctNumbersCount != NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    ErrorMessage.NON_DUPLICATED_NUMS.getErrorMessage()
            );
        }
    }
}
