package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class SetUserLotto {
    public Lotto userLotto() {
        List<Integer> numbers = InputNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> InputNumbers() {
        String[] input = Console.readLine().split(",");
        List<Integer> inputNumbers = new ArrayList<>();

        try {
            for (String str : input) {
                rangeValidation(Integer.parseInt(str));
                inputNumbers.add(Integer.parseInt(str));
            }
            sizeValidation(inputNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.INVALID_INPUT_NUMBER.getMessage());
        }

        return inputNumbers;
    }

    public int bonusNumber() {
        int number = Integer.parseInt(Console.readLine());
        try {
            bonusNumberValidation(number);
            rangeValidation(number);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.INVALID_INPUT_NUMBER.getMessage());
        }
        return number;
    }

    private void bonusNumberValidation(int number) {
        if(userLotto().getNumbers().contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
        }

    }

    private void sizeValidation(List<Integer> numbers) {
        if (numbers.size() != 6) {
            if(numbers.isEmpty()){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_EMPTY.getMessage());
            }
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void rangeValidation(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

}
