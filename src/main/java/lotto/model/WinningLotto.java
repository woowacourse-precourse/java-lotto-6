package lotto.model;

public class WinningLotto {
    private static final String ERROR_DUPLICATED_BONUS = "[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.";
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        validateDuplicatedNumber(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Bonus getBonus() {
        return bonus;
    }

    private void validateDuplicatedNumber(Lotto lotto, Bonus bonus) {
        if (lotto.isDuplicatedBonus(bonus.getBonusNumber())) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_BONUS);
        }
    }
}
