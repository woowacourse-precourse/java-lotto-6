package lotto.model;

public record BonusNumber(
        int bonusNumber
) {

    public void validateIsDuplicate(Lotto winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호과 중복되지 않는 숫자를 입력해야 합니다.");
        }
    }
}
