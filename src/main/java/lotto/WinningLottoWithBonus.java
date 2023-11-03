package lotto;

import lotto.exception.ExceptionManager;

public class WinningLottoWithBonus {

    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private final Lotto lotto;
    private final int bonus;

    public WinningLottoWithBonus(Lotto lotto, int bonus) {
        bonusValid(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

    private void bonusValid(Lotto lotto, int number) {
        checkBonusNumRange(number);
        checkDuplicate(lotto, number);
    }

    private void checkBonusNumRange(int number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            ExceptionManager.throwIllegalArgumentExceptionWithMsg("로또의 숫자는 " + LOTTO_START + "~" + LOTTO_END + "까지 가능합니다.");
        }
    }

    private void checkDuplicate(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            ExceptionManager.throwIllegalArgumentExceptionWithMsg("로또의 숫자는 중복될 수 없습니다.");
        }
    }
}
