package lotto.domain.wrapper;

import java.util.List;

import static lotto.handler.ConstantsHandler.MAX_LOTTO_NUMBER;
import static lotto.handler.ConstantsHandler.MIN_LOTTO_NUMBER;
import static lotto.handler.ErrorHandler.*;

public class WinLottoWithBonus {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    private WinLottoWithBonus(List<Integer> winningLotto, String bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = validateType(bonusNumber);

        validateDuplicate(this.bonusNumber);
        validateRange(this.bonusNumber);
    }

    public static WinLottoWithBonus create(List<Integer> winningLotto, String bonusNumber) {
        return new WinLottoWithBonus(winningLotto, bonusNumber);
    }

    private int validateType(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw INCONVERTIBLE_TYPE.getException();
        }
    }

    private void validateDuplicate(int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw DUPLICATE_NUMBER.getException();
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw INVALID_RANGE.getException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }
}
