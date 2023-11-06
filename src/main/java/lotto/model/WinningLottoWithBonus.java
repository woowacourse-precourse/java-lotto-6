package lotto.model;

import static lotto.constants.LottoConstants.LOTTO_END;
import static lotto.constants.LottoConstants.LOTTO_START;

import lotto.exception.ExceptionManager;

public class WinningLottoWithBonus {

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
            throw ExceptionManager.BEGIN_ERROR.createIllegalArgumentException(
                    "로또의 숫자는 " + LOTTO_START + "~" + LOTTO_END + "까지 가능합니다.");
        }
    }

    private void checkDuplicate(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            throw ExceptionManager.BEGIN_ERROR.createIllegalArgumentException(
                    "로또의 숫자는 중복될 수 없습니다.");
        }
    }
}
