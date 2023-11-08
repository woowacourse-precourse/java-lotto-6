package lotto.controller;


import lotto.model.*;
import lotto.service.TicketService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;

public class LottoController {

    public void run() {
        LottoPrice lottoPrice = InputView.inputPrice();
        Ticket ticket = TicketService.createTicket(lottoPrice.getLottoPrice());
        OutputView.printLottoCount(ticket.getPurchaseNum());
        OutputView.printTicket(ticket);
        Lotto winningNumber = InputView.inputWinningNumber();
        BonusNumber bonusNumber = InputView.inputBonusNumber();
    }
}
