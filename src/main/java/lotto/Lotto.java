package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private ValidateTools validateTools = new ValidateTools();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateTools.validate6Nums(numbers);
        validateTools.validateDuplicateLottos(numbers);
        for (int num: numbers){
            validateTools.validate1to45(num);
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

}
