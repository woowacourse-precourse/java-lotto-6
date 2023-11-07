package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Lotto(List<Integer> numbers) {

    public Lotto {
        validate(numbers);
    }

    public void sortNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Integer> numbers() {
        return new ArrayList<>(numbers);
    }

}