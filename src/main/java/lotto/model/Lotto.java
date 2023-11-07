package lotto.model;

import java.util.List;

public class Lotto {
    private static final String INVALID_LOTTO_MESSAGE = "[ERROR] 6개의 로또 번호를 입력해야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            builder.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
