package lotto.model;

import static lotto.util.Constant.LOTTO_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (validateLength(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_LENGTH.getMessage());
        }
        if (validateDuplicate(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_DUPLICATE.getMessage());
        }
    }

    private boolean validateDuplicate(List<Integer> numbers) {
        return  numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size() != LOTTO_LENGTH;
    }

    private boolean validateLength(List<Integer> numbers) {
        return numbers.size() != LOTTO_LENGTH;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
    public boolean contains(int number) {
        return numbers.contains(number);
    }
    @Override
    public String toString(){
        return numbers.toString();
    }
}
