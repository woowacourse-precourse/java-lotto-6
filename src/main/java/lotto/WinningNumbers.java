package lotto;

import java.util.List;

public record WinningNumbers(Lotto numbers, int bonusNumber) {
    public WinningNumbers {
        validate(numbers, bonusNumber);
    }

    private void validate(Lotto numbers, int bonusNumber) {
        validate(numbers);
        validate(bonusNumber);
        validateNotDuplicated(numbers, bonusNumber);
    }

    private void validate(Lotto numbers) {
        numbers.getSortedNumbers().forEach(this::validateNumberInRange);
    }

    private void validate(int bonusNumber) {
        validateNumberInRange(bonusNumber);
    }

    private void validateNumberInRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }

    private void validateNotDuplicated(Lotto numbers, int bonusNumber) {
        List<Integer> winningNumbers = numbers.getSortedNumbers();
        winningNumbers.add(bonusNumber);
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
