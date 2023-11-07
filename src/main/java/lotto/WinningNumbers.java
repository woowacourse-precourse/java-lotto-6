package lotto;

import java.util.List;

public record WinningNumbers(Lotto winningLotto, int bonusNumber) {
    public WinningNumbers {
        validate(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto);
        validate(bonusNumber);
        validateNotDuplicated(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto) {
        winningLotto.getNumbers().forEach(this::validateNumberInRange);
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
        List<Integer> winningNumbers = numbers.getNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
