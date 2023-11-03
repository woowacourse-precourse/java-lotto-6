package lotto.controller;

import lotto.model.domain.Lotto;
import lotto.model.domain.Player;
import lotto.model.domain.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Player player = getPlayer();
        showPlayerLotto(player);
        Prize prize = getPrize(getPrizeLotto());
        System.out.println(prize);
    }

    private Player getPlayer() {
        try {
            return Player.from(InputView.getLottoMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }

    private void showPlayerLotto(Player player) {
        OutputView.printPlayerAmount(player.getAmount());
        player.getLotto().forEach(lotto -> OutputView.printPlayerLotto(lotto.toString()));
    }

    private Prize getPrize(Lotto lotto) {
        int bonus = InputView.getLottoBonus();
        try {
            return Prize.of(lotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrize(lotto);
        }
    }

    private Lotto getPrizeLotto() {
        try {
            return new Lotto(InputView.getLottoPrize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrizeLotto();
        }
    }
}
