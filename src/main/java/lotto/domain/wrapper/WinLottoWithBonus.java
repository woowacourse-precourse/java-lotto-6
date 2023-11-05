package lotto.domain.wrapper;

import java.util.List;

import static lotto.handler.ErrorHandler.DUPLICATE_NUMBER;
import static lotto.handler.ErrorHandler.INCONVERTIBLE_TYPE;

public class WinLottoWithBonus {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    private WinLottoWithBonus(List<Integer> winningLotto, String bonusNumber) {
        this.bonusNumber = validateType(bonusNumber);
        this.winningLotto = winningLotto;
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

    private void validateDuplicate() {
        if (winningLotto.contains(bonusNumber)) {
            throw DUPLICATE_NUMBER.getException();
        }
    }
}
