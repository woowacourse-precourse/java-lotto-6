package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final boolean isJackpot;

    public Lotto(List<Integer>numbers) {
        this(numbers, false);
    }

    public Lotto(List<Integer> numbers, boolean isJackpot) {
        validate(numbers);
        this.numbers = numbers;
        this.isJackpot = isJackpot;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
    }

    public String toTextFormat() {
        StringBuilder sb = new StringBuilder("[");
        numbers.forEach(number -> sb.append(number)
                .append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public boolean isJackpotLotto() {
        return isJackpot;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 되어있어야 합니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException("중복이 포함되어 있습니다.");
        }
    }
}
