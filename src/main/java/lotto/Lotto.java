package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 정확히 6개여야 합니다.");
        }

        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있으면 안됩니다.");
        }

        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                return true; // 중복된 숫자가 있는 경우
            }
            uniqueNumbers.add(number);
        }
        return false;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
