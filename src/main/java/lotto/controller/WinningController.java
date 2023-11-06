package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Winning;
import lotto.view.InputView;

public class WinningController {
    public Winning createWinning(Lotto lotto) {
        int bonus = InputView.getLottoBonus();
        try {
            return Winning.of(lotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinning(lotto);
        }
    }

    public Lotto getWinningLotto() {
        try {
            return new Lotto(InputView.getLottoWinnning());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }
}
