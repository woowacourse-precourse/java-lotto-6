package lotto.lotto;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int compare(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return (int) IntStream.range(0, 6)
                .filter(i -> this.numbers.contains(numbers.get(i)))
                .count();
    }

    private void validate(List<Integer> numbers) {
        checkListSize(numbers);
        checkNumberRange(numbers);
        checkDuplication(numbers);
    }

    private void checkListSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자를 6개 입력해 주세요.");
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("1~45 사이의 숫자를 입력해 주세요.");
            }
        });
    }

    private void checkDuplication(List<Integer> numbers) {
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != count) {
            throw new IllegalArgumentException("숫자가 중복되지 않게 입력해 주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
