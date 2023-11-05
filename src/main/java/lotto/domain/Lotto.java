package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        boolean[] checkDuplication = new boolean[46];
        Arrays.fill(checkDuplication, false);

        for(int number : numbers){
            if(checkDuplication[number]) throw new IllegalArgumentException();
            checkDuplication[number] = true;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
