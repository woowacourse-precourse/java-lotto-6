package lotto.domain;

public class BonusNumber {

    private Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumber(Integer bonusNumber) {
        validateBonusNumberRange(bonusNumber);
    }

    private static void validateBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위의 정수이어야 합니다.");
        }
    }
}
