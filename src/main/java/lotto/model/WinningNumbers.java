package lotto.model;

public class WinningNumbers {

    private Lotto winningNumbers;
    private Integer bonusNumber;

    private WinningNumbers(Lotto lotto, Integer bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateWithWinningNumbers(lotto, bonusNumber);
        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(Lotto lotto, Integer bonusNumber) {
        return new WinningNumbers(lotto, bonusNumber);
    }

    public boolean hasNumberInWinningNumbers(Integer number) {
        return winningNumbers.hasNumber(number);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateDuplicateWithWinningNumbers(Lotto lotto, Integer bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 숫자는 입력할 수 없습니다.");
        }
    }

    private void validateNumberRange(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 범위는 입력될 수 없습니다.");
        }
    }
}
