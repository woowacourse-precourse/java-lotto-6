package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoVaildationInterface.lottoValidation(new LottoValidation(),numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> sorted(List<Integer> numbers){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
