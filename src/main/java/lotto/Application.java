package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputValidator;
import lotto.service.LottoFactory;
import lotto.service.LottoMachine;
import lotto.service.LottoNumberGenerator;
import lotto.model.LottoTickets;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View consoleView = new View();
        InputValidator inputValidator = new InputValidator();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        LottoFactory lottoFactory = new LottoFactory(lottoNumberGenerator);
        LottoTickets lottoTickets = new LottoTickets();
        LottoMachine lottoMachine = new LottoMachine(lottoFactory, lottoTickets);

        LottoGameController controller = new LottoGameController(consoleView, lottoMachine, inputValidator);

        controller.startGame();
    }
}
