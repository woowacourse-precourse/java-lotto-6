package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.List;

public class AnswerLotto {
    private final List<Integer> numbers;

    public AnswerLotto(List<Integer> numbers) {
        validateAnswerLotto(numbers);
        this.numbers = numbers;
    }
    public int countMatchNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public boolean hasNumber(int number) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(member -> member == number)
                .findAny()
                .isPresent();
    }

    private void validateAnswerLotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicateMember(numbers);
        validateAllNumberInRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (checkLength(numbers)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LOTTO_LENGTH_ERROR.getMessage(),
                            NumberType.LOTTO_LENGTH.getValue()));
        }
    }

    private boolean checkLength(List<Integer> numbers) {
        return numbers.size() != NumberType.LOTTO_LENGTH.getValue();
    }

    private void validateDuplicateMember(List<Integer> numbers) {
        if (checkHasDuplicateMember(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_HAS_DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private boolean checkHasDuplicateMember(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private void validateAllNumberInRange(List<Integer> numbers) {
        if (!checkAllNumberInRange(numbers)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.LOTTO_NOT_IN_RANGE_ERROR.getMessage(),
                    NumberType.MIN_LOTTO_NUMBER.getValue(), NumberType.MAX_LOTTO_NUMBER.getValue()));
        }
    }

    private boolean checkAllNumberInRange(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> checkNumberInRange(num))
                .count() == numbers.size();
    }

    private boolean checkNumberInRange(int number) {
        return number >= NumberType.MIN_LOTTO_NUMBER.getValue() && number <= NumberType.MAX_LOTTO_NUMBER.getValue();
    }
}
