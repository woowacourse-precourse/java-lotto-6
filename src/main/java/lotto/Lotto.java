package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Exception.lottoNumberValidate(numbers);
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return numbers;
    }
}
