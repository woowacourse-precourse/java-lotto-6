package lotto.model;

import static lotto.constants.LottoDetails.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        validateLottoSize(numbers);
        validateDistinctNumbers(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int matchNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
