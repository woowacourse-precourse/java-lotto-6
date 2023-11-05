package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoTicketService;

public class Application {
    public static void main(String[] args) {
        LottoTicketService lottoTicketService = new LottoTicketService();
        LottoController lottoController = new LottoController(lottoTicketService);
        lottoController.run();
    }
}
