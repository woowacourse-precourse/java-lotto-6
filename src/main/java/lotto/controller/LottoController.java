package lotto.controller;

import lotto.model.domain.Player;
import lotto.model.dto.PlayerRequestDto;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        System.out.println(getPlayer());
    }

    private Player getPlayer() {
        try {
            PlayerRequestDto playerRequestDto = InputView.getLottoMoney();
            return playerRequestDto.toPlayer();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }
}
