package lotto.v3.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {
    private final Set<Integer> numbers;

    public LottoWinningNumber(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해야 합니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (!numbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 값이어야 합니다.");
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
