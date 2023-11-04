package lotto.domain;

public class WinningNumbers {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(final Lotto lotto, final BonusNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(final Lotto lotto, final BonusNumber bonusNumber) {
        if (isContains(lotto, bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또와 다른 번호로 입력해주세요.");
        }
    }

    private static boolean isContains(final Lotto lotto, final BonusNumber bonusNumber) {
        return lotto.contains(bonusNumber.value());
    }
}