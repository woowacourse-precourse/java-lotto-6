package lotto;

import java.util.List;

public record WinningNumbers(Lotto winningNumbers, int bonusNumber) {
    public WinningNumbers {
        validate(winningNumbers, bonusNumber);
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers);
        validate(bonusNumber);
        validateNotDuplicated(winningNumbers, bonusNumber);
    }

    private void validate(Lotto winningNumbers) {
        winningNumbers.getSortedNumbers().forEach(this::validateNumberInRange);
    }

    private void validate(int bonusNumber) {
        validateNumberInRange(bonusNumber);
    }

    private void validateNumberInRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }

    private void validateNotDuplicated(Lotto winningNumbers, int bonusNumber) {
        List<Integer> winningNumbersList = winningNumbers.getSortedNumbers();
        winningNumbersList.add(bonusNumber);
        if (winningNumbersList.stream().distinct().count() != winningNumbersList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
