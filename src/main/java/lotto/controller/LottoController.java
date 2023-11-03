package lotto.controller;

import lotto.model.domain.Player;
import lotto.model.dto.LottoResponseDto;
import lotto.model.dto.PlayerRequestDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Player player = getPlayer();
        showPlayerLotto(player);
        System.out.print(InputView.getLottoPrize());
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

    private void showPlayerLotto(Player player) {
        OutputView.printPlayerAmount(player.getAmount());
        player.getLotto().forEach(lotto -> OutputView.printPlayerLotto(new LottoResponseDto(lotto.getNumbers())));
    }
}
