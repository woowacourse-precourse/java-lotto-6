package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }

        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchNumbers(List<Integer> winningNumbers) {
        int matched = 0;
        for (int number : winningNumbers) {
            if (numbers.contains(number)) {
                matched++;
            }
        }
        return matched;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }


}
