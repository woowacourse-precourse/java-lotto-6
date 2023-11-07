package lotto.domain;

public record WinningNumber(Lotto lotto, BonusNumber bonusNumber) {
    public WinningNumber {
        validateDuplicate(lotto, bonusNumber);
    }

    private void validateDuplicate(final Lotto lotto, final BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또와 다른 번호로 입력해주세요.");
        }
    }
}