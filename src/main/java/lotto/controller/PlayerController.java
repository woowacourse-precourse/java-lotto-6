package lotto.controller;

import lotto.model.lotto.Player;
import lotto.model.lotto.PlayerAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PlayerController {
    public Player createPlayer() {
        PlayerAmount playerAmount = getPlayerAmount();
        return Player.from(playerAmount);
    }

    public void showPlayerLotto(Player player) {
        OutputView.printPlayerAmount(player.getPlayerAmount());
        player.getPlayerLotto().forEach(lotto -> OutputView.printPlayerLotto(lotto.toString()));
    }

    private PlayerAmount getPlayerAmount() {
        try {
            return PlayerAmount.getInstance(InputView.getPlayerLottoMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerAmount();
        }
    }
}