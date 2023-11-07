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
        } //보너스 로또 번호 범위 검사
    }

    private Boolean validateBonusRange(int bonus) {
        if (bonus < Range.START.content() || bonus > Range.END.content()) {
            return true;
        }
        return false;
    }

    public void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(ExceptionList.BONUSLOTTODUPLICATIONEXCEPTION.content());
        } //보너스 로또 번호 중복 검사
    }
}
