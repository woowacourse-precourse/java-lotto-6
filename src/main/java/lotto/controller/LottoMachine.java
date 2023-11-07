package lotto.controller;

import lotto.View;
import lotto.constant.ErrorMessage;
import lotto.constant.ViewMessage;
import lotto.model.Lotto;

public class LottoMachine {
    private final View view = new View();
    private final LottoController lottoController = new LottoController();

    public Lotto readWinningNumber() {
        Lotto lotto = null;

        view.printLine();
        view.print(ViewMessage.ASK_WINNING_NUMBER.getMessage());
        do {
            try {
                lotto = new Lotto(lottoController.readWinningNumber());
            } catch (IllegalArgumentException e) {
                view.print(ErrorMessage.INVALID_WINNING_NUMBER.getErrorMessage());
            }
        } while (lotto == null);
        return lotto;
    }

    public int readBonusNumber(Lotto winningLotto) {
        int bonusNumber;

        view.printLine();
        view.print(ViewMessage.ASK_BONUS_NUMBER.getMessage());
        do {
            try {
                bonusNumber = lottoController.readBonusNumber();
                validateBonusNumber(bonusNumber, winningLotto);
            } catch (IllegalArgumentException e) {
                view.print(ErrorMessage.INVALID_BONUS_NUMBER.getErrorMessage());
                bonusNumber = 0;
            }
        } while (bonusNumber == 0);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getLottoNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
