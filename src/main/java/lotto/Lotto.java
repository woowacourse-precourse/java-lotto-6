package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        arrangeNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 각각의 로또는 6개의 수여야 합니다.");
        }
    }
    
    private void arrangeNumbers() {
        Collections.sort(numbers);
    }
    
    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
