package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoTicketGenerator;
import lotto.service.LottoService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        ConsoleInputView consoleInputView = new ConsoleInputView();
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(consoleInputView, consoleOutputView, lottoService, lottoTicketGenerator);
        lottoController.lottoGamePlay();
    }
}
