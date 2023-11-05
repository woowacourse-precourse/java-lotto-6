package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoTicketService;
import lotto.service.WinningNumberService;

public class Application {
    public static void main(String[] args) {
        LottoTicketService lottoTicketService = new LottoTicketService();
        WinningNumberService winningNumberService = new WinningNumberService();
        LottoController lottoController = new LottoController(lottoTicketService, winningNumberService);
        lottoController.run();
    }
}
