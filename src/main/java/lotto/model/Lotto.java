package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto extends ValidateLottoNumbers {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
