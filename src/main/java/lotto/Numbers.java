package lotto;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    Numbers(List<String> inputs) {
        this.numbers = validate(inputs);
    }

    private List<Integer> validate(List<String> inputs) {
        return validateNumbers(inputs);
    }

    private List<Integer> validateNumbers(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            int number = new Number(input).getNumber();
            numbers.add(number);
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
