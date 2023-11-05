package lotto.domain.wrapper;

import static lotto.handler.ErrorHandler.INCONVERTIBLE_TYPE;

public class WinLottoWithBonus {

    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinLottoWithBonus(Lotto winningLotto, String bonusNumber) {
        this.bonusNumber = validateType(bonusNumber);
        this.winningLotto = winningLotto;
    }

    public static WinLottoWithBonus create(Lotto winningLotto, String bonusNumber) {
        return new WinLottoWithBonus(winningLotto, bonusNumber);
    }

    private int validateType(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw INCONVERTIBLE_TYPE.getException();
        }
    }
}
