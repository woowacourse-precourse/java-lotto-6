package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        CheckNumberSize(numbers);
        CheckOverlap(numbers);
        CheckValidateNumbers(numbers);
    }

    private void CheckNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 총 갯수는 6개여야 합니다.");
        }
    }

    private void CheckOverlap(List<Integer> numbers) {
        Set<Integer> temp_set = new HashSet<>(numbers);

        if (temp_set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }

    }

    private static void CheckValidateNumbers(List<Integer> numbers) {
        for (int a : numbers) {
            if (a < 1 || a > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public int CompWinner(Lotto winner) {
        return (int) numbers.stream().filter(winner::ContainNumber).count();
    }

    public boolean ContainNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
