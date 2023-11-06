package model;

import java.util.List;
import utils.NumberValidation;
import utils.NumbersValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validate(List<Integer> numbers){
        NumbersValidation.isOverLength(numbers);
        NumbersValidation.isUnderLength(numbers);
        NumbersValidation.duplicationNumbers(numbers);
        numbers.stream().forEach(number-> NumberValidation.isOverMaxNumber(number));
        numbers.stream().forEach(number-> NumberValidation.isUnderMinNumber(number));
    }
}
