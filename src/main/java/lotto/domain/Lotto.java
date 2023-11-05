package lotto.domain;

import java.util.List;

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

    public int countMatchingNumbers(List<Integer> lottoWinningNumbers){
        return (int) lottoWinningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }
    public boolean checkBonusNumber(int bonusNumber){
        return numbers.stream().anyMatch(number -> number == bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
