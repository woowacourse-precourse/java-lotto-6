package lotto;

import java.util.List;
import util.RegexPattern;
import util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_LIMIT.getErrorMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.CANT_DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!RegexPattern.lotto.matcher(Integer.toString(number)).matches()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getErrorMessage());
            }
        }

    }

}
