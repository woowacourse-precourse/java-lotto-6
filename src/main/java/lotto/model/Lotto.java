package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        hasDuplication(numbers);
        validateLottoRange(numbers);
    }

    private void validateLottoRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45 입니다.");
            }
        });
    }

    private void hasDuplication(List<Integer> numbers) {
        HashSet<Integer> numbersDuplicationRemoved = new HashSet<>(numbers);
        if (numbersDuplicationRemoved.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = numbers.size() - 1;
        IntStream.rangeClosed(start, end).forEach(index -> {
            if (index == start) {
                sb.append("[").append(numbers.get(index)).append(", ");
            }
            if (index == end) {
                sb.append(numbers.get(index)).append("]");
            }
            if (index != start && index != end) {
                sb.append(numbers.get(index)).append(", ");
            }
        });
        return sb.toString();
    }
}
