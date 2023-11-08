package lotto.model;

import java.util.List;

import static lotto.constant.ErrorMessage.ERROR_WIN_NUMBERS_DUPLICATES;
import static lotto.constant.ErrorMessage.ERROR_WIN_NUMBERS_SIZE_IS_NOT_6;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_WIN_NUMBERS_SIZE_IS_NOT_6);
        }
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ERROR_WIN_NUMBERS_DUPLICATES);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
