package lotto;

public class BonusLotto {
    private final Integer bonus;

    public BonusLotto(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    private void validate(int bonus) {
        if (validateBonusRange(bonus)) {
            throw new IllegalArgumentException(ExceptionList.BONUSLOTTORANGEEXCEPTION.content());
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
            throw new IllegalArgumentException(ExceptionList.BONUSLOTTODUPLICATIONEXCEPTION.content());
        }
    }
}
