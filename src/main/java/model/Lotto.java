package model;

import validate.Validator;

import java.util.List;

public class Lotto {


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.checkNull(numbers.toString());
        validator.checkDuplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
