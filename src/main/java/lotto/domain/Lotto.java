package lotto.domain;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;
import static lotto.exception.LottoNumberException.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public String getLottoNumbersText() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }
}
