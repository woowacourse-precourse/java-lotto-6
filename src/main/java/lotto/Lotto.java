package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    //TODO : InputView에서 가져옴
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        try {
            validateLength(numbers);
            validateNumbers(numbers);
            validateDuplicates(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            InputVIew.inputWinningNumbers();
        }
    }
    private void validateLength(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private  void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
    private  void validateDuplicates(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();
        for (Integer number : numbers) {
            if (seen.contains(number)) {
                throw new IllegalArgumentException();
            }
            seen.add(number);
        }
    }

}
