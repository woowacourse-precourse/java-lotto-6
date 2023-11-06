package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbers(numbers);
        validateIsUnique(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbers(List<Integer> numbers){
        if(!numbers.stream().allMatch(n->n>=1&&n<=45)){
            throw new IllegalArgumentException();
        }
    }

    private void validateIsUnique(List<Integer> numbers){
        if(numbers.stream().distinct().count()!=numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
