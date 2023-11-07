package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> districtNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if(districtNumbers.size() != numbers.size()) throw new IllegalArgumentException();
    }
}
