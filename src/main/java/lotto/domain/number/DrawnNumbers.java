package lotto.domain.number;

public class DrawnNumbers {
    private static final String DUPLICATES_FOUND = "보너스 번호는 당첨 번호에 포함되지 않는 숫자여야 합니다.";
    private final Lotto winningNumbers;
    private final Number bonusNumber;

    public DrawnNumbers(Lotto winningNumbers, Number bonusNumber) {
        validateNoDuplicates(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNoDuplicates(Lotto winningNumbers, Number bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATES_FOUND);
        }
    }
}
