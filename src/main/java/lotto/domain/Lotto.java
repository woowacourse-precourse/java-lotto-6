package lotto.domain;

import static lotto.domain.LottoDetails.LOTTO_SIZE;
import static lotto.view.ErrorMessage.ERROR;

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
            throw new IllegalArgumentException(ERROR);
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int match(Lotto lotto) {
        return (int) numbers.stream().filter(lotto::containsNumber).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
