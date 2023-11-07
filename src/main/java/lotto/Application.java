package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoTicketGenerator;
import lotto.service.LottoService;
import lotto.view.ConsoleInputView;

public class Application {
    public static void main(String[] args) {

        ConsoleInputView consoleInputView = new ConsoleInputView();
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(consoleInputView, lottoService, lottoTicketGenerator);
        lottoController.lottoGamePlay();
    }
}
