package lotto.controller;

import lotto.utils.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.WINNING_NUMBER_TOTAL.printValue();
            throw new IllegalArgumentException();
        }
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public boolean validate(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            ExceptionMessage.NUMBER.printValue();
            return false;
        }

        if(0 >= num || num > 45) {
            ExceptionMessage.WINNING_NUMBER_RANGE.printValue();
            return false;
        }
        return true;
    }

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> deleteDupliNumber = new HashSet<>(numbers);
        if(numbers.size() != deleteDupliNumber.size()) {
            ExceptionMessage.WINNING_NUMBER_DUPLICATE.printValue();
            throw new IllegalArgumentException();
        }
    }

    public void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if(0 >= number || number > 45) {
                ExceptionMessage.WINNING_NUMBER_RANGE.getValue();
                throw new IllegalArgumentException();
            }
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
