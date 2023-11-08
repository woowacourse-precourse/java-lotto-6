package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.Player;
import lotto.util.LottoAgency;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {


    public void startGame() {
        Player player = inputAmount();
        ticketingLotto(player);

        OutputView.printPlayerLottoTicketInfo(player);
    }

    private static Player inputAmount() {
        try {
            return new Player(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputAmount();
        }
    }

    private void ticketingLotto(Player player) {
        int quantity = player.getPlayerTicketQuantity();
        OutputView.printBuyingTicketQuantity(player);
        player.setLottoTicket(LottoAgency.createAutoTicket(quantity));
    }
}
