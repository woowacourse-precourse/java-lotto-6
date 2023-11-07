package lotto.domain;

import lotto.utility.enums.ExceptionMessages;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_SIX_NUMBERS.getMessage());
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessages.IS_NUMBERS_DUPLICATION.getMessage());
        }
    }
}
