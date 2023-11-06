package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final Bonus bonus;
    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private WinningLotto(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(Lotto lotto, Bonus bonus) {
        validateBonusNumberDuplicate(lotto, bonus.getBonus());
        return new WinningLotto(lotto, bonus);
    }

    private static void validateBonusNumberDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
