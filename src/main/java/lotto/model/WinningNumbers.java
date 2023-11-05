package lotto.model;

public class WinningNumbers {

    private Lotto winningNumbers;
    private Integer bonusNumber;

    public WinningNumbers(Lotto lotto, Integer bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public PriceMoney calculate(Lotto lotto) {
        int count = winningNumbers.sameNumberCounter(lotto);
        boolean hasbonusNumber = lotto.hasNumber(bonusNumber);
        return PriceMoney.getRank(count, hasbonusNumber);
    }

    private void validateDuplicateNumber(Lotto lotto, Integer bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 숫자는 입력할 수 없습니다.");
        }
    }
}
