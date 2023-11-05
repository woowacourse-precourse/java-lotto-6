package lotto.domain;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        sortAscending(numbers);
        return this.numbers;
    }

    public int compareLottoWithWinningNumber(LottoNumbers winningNumber) {
        List<Integer> numbers = winningNumber.getLottoNumbers();
        return (int) numbers.stream().filter(this::contains).count();
    }

    public boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sortAscending(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
