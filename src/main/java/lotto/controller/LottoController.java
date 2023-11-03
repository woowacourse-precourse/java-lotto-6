package lotto.controller;

import lotto.model.domain.Player;
import lotto.model.dto.MoneyRequestDto;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        getPlayer();
    }

    private Player getPlayer() {
        try {
            MoneyRequestDto moneyRequestDto = InputView.getLottoMoney();
            return moneyRequestDto.toPlayer();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }
}
