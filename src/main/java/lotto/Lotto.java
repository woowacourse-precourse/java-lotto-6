package lotto;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
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

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public Lotto ascendingSort() {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(sortedNumbers);
    }

    public Rank getRankResult(WinningLotto winningLotto) {
        return winningLotto.match(this);
    }
}
