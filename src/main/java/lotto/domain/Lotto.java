package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        int numberCount = new HashSet<>(numbers).size();
        if (numberCount != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoMatch compareWinningNumbers(final List<Integer> winningNumbers, final int bonusNumber) {
        int count = 0;
        boolean isBonus = false;

        if (numbers.contains(bonusNumber)) {
            count++;
            isBonus = true;
        }

        for (int winingNumber : winningNumbers) {
            if (numbers.contains(winingNumber)) count++;
        }
        return LottoMatch.getLottoMatch(count, isBonus);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }
}
