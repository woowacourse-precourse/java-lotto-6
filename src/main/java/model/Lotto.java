package model;

import java.util.Collections;
import java.util.List;
import utils.NumberValidation;
import utils.NumbersValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void sortNumbers(){
       Collections.sort(numbers);
    }

    public void validate(List<Integer> numbers) {
        NumbersValidation.isOverLength(numbers);
        NumbersValidation.isUnderLength(numbers);
        NumbersValidation.duplicationNumbers(numbers);
        numbers.stream().forEach(number -> numberValidate(number));
    }

    public void numberValidate(int number) {
        NumberValidation.isUnderMinNumber(number);
        NumberValidation.isOverMaxNumber(number);
    }
}
