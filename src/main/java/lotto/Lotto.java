package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }

        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 같은 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        Collections.sort(modifiableNumbers);
        return modifiableNumbers;
    }


}
