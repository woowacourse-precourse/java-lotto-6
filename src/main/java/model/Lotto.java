package model;

import view.PrintError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final PrintError printError = new PrintError();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            printError.numberSizeMessage();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                printError.numberRangeMessage();
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }


    public void printLotto() {
        System.out.println(numbers);
    }
}
