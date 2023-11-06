package lotto.domain.player;

public class BonusNumber {

    private Integer bonusNumber;

    private BonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber create(Integer bonusNumber) {
        return new BonusNumber(bonusNumber);
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
