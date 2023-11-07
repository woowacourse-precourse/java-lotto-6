package lotto.controller;

import lotto.utils.ExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_TOTAL.getValue());
        }
        numbers.forEach(number -> {
            if(0 >= number && number > 45) {
                throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_RANGE.getValue());
            }
        });
    }

    public void validate(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER.getValue());
        }

        if(0 >= num && num > 45) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_RANGE.getValue());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
