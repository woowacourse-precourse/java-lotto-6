package lotto.Model.Domain;

import java.util.List;
import System.Exception;

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

        long distinctSize = numbers.stream().distinct().count();
        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException(
                    Exception.LOTTO_DUPLICATE_NUMBER_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
