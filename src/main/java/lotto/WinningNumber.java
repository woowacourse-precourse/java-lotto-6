package lotto;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSix(numbers);
        isDuplicate(numbers);
        isInRange(numbers);
    }

    private void isSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해야 합니다.");
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        HashSet<Integer> temp = new HashSet<>(numbers);
        if (temp.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복됩니다.");
        }
    }

    private void isInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.numbers;
    }
}
