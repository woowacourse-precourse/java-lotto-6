package lotto.domain;


public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(Lotto answerLotto, int bonusNumber) {
        validateBonusNumber(answerLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(Lotto answerLotto, int bonusNumber) {
        return new BonusNumber(answerLotto, bonusNumber);
    }

    private void validateBonusNumber(Lotto answerLotto, int bonusNumber) {
        validateBonusNumberSize(bonusNumber);
        validateDuplicateBonusNumber(answerLotto, bonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto answerLotto, int bonusNumber) {
        if(answerLotto.containsBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] : 정답 번호와 동일한 보너스 번호가 있으면 안됩니다.");
        }
    }

    private void validateBonusNumberSize(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] : 보너스 번호는 1~45 사이 입니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
