package lotto;

import java.util.List;

public record WinningNumbers(Lotto numbers, int bonusNumber) {
    public WinningNumbers {
        validate(numbers, bonusNumber);
    }

    public Lotto getLottoNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto numbers, int bonusNumber) {
        validate(numbers);
        validate(bonusNumber);
        validateNotDuplicated(numbers, bonusNumber);
    }

    private void validate(Lotto numbers) {
        numbers.getNumbers().forEach(this::validateNumberInRange);
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
