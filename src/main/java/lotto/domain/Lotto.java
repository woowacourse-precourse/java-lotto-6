package lotto.domain;

import java.util.Collections;
import java.util.List;
import static lotto.system.Constant.LOTTO_LENGTH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getconstant()) {
            throw new IllegalArgumentException();
        }
    }
    
    public List<Integer> getNumbers() {
    	return Collections.unmodifiableList(numbers);
    }
}
