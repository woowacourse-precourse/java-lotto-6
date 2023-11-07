package lotto;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String sayNumbers() {
        String numberLine = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        return MessageFormat.format("[{0}]", numberLine);
    }

    // TODO: 추가 기능 구현
}
