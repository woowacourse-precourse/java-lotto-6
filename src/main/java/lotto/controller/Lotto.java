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
            ExceptionMessage.WINNING_NUMBER_TOTAL.printValue();
            new LottoGame().inputWinninNumber();
        }
        numbers.forEach(number -> {
            if(0 >= number && number > 45) {
                ExceptionMessage.WINNING_NUMBER_RANGE.getValue();
                new LottoGame().inputWinninNumber();
            }
        });
    }

    public boolean validate(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            ExceptionMessage.NUMBER.printValue();
            return false;
        }

        if(0 >= num && num > 45) {
            ExceptionMessage.WINNING_NUMBER_RANGE.printValue();
            return false;
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
