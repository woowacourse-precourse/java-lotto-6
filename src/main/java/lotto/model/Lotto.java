package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private List<Integer> InputNumbers() {
        String[] input = Console.readLine().split(",");
        List<Integer> inputNumbers = new ArrayList<>();

        for (String str : input) {
            inputNumbers.add(Integer.parseInt(str));
        }

        return inputNumbers;
    }

    public int bonusNumber() {
        int number = Integer.parseInt(Console.readLine());
        bonusNumberValidation(number);
        rangeBonusValidation(number);
        return number;
    }

    private void bonusNumberValidation(int number) {
        Lotto lotto = new Lotto(numbers);

        if(lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
        }

    }

    private void sizeValidation(List<Integer> numbers) {
        if (numbers.size() != 6) {
            if(numbers.size() == 0){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_EMPTY.getMessage());
            }
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void rangeValidation(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void rangeBonusValidation(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
