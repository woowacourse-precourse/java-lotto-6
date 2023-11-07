package lotto.domain;

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
        checkSize(numbers);
        checkUnique(numbers);
        checkRange(numbers);
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또번호가 6개가 아닙니다.");
        }
    }

    private static void checkUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 존재하면 안됩니다.");
        }
    }

    private static void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("숫자는 1에서 45 사이어야 합니다: " + number);
            }
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
