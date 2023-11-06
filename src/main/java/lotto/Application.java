package lotto;

import lotto.adapter.ConsoleInputAdapter;
import lotto.controller.LottoGameController;
import lotto.port.InputPort;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        InputPort inputPort = new ConsoleInputAdapter();
        LottoService lottoService = new LottoService();
        LottoGameController lottoGameController = new LottoGameController(inputPort, lottoService);
        lottoGameController.playGame();
    }
}
