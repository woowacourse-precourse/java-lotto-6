package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        String validate = String.join(",",
                numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())
        );
        new LottoValidator().validate(validate);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
