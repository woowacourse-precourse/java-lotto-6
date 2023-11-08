package lotto.Model.Domain;

import java.util.List;
import System.Exception;
import System.Constant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.LOTTO_SIZE_EXCEPTION.getMessage());
        }

        if(!validateNumber(numbers)) {
            throw new IllegalArgumentException(Exception.LOTTO_WRONG_NUMBER_EXCEPTION.getMessage());
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(
                    Exception.LOTTO_DUPLICATE_NUMBER_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean validateNumber(List<Integer> numbers) {
        return numbers.stream().allMatch(x -> Constant.LOTTO_MIN_VALUE.getConstant() <= x
                && Constant.LOTTO_MAX_VALUE.getConstant() >= x);
    }

}
