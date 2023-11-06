package lotto;

public class BonusLotto{
    private final Integer bonus;

    public BonusLotto(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        if (validateBonusRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또는 1에서 45 사이 정수여야 합니다.");
        }
    }

    private Boolean validateBonusRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            return true;
        }
        return false;
    }

    public void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또는 중복되지 않은 수여야 합니다.");
        }
    }
}
