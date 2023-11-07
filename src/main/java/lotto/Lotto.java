package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Issue.NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException();
        }

        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<Integer>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> convertType() {
        return numbers;
    }

}
