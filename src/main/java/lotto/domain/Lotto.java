package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import static lotto.exception.LottoNumberException.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public String getLottoNumbersText() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        String[] numbersText = numbers.stream()
                .map(String::valueOf)
                .toArray(String[]::new);

        for (String text : numbersText) {
            joiner.add(text);
        }
        return joiner.toString();
    }
}
