package lotto.domain;

import static lotto.constant.LottoConstants.LOTTO_SIZE;

import java.util.List;

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
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int compareNumbers(Lotto lotto) {
        return (int) numbers.stream().flatMap(
                number -> lotto.getNumbers()
                        .stream()
                        .filter(number::equals)
        ).count();
    }
}
