package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String START_TAG = "[";
    private static final String SEPARATOR = ", ";
    private static final String END_TAG = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_TAG);
        List<String> nums_str = numbers.stream().map(String::valueOf).toList();
        sb.append(String.join(SEPARATOR, nums_str));
        sb.append(END_TAG);
        return sb.toString();
    }
}
