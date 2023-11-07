package lotto;

import lotto.adapter.ConsoleInputAdapter;
import lotto.adapter.ConsoleOutputAdapter;
import lotto.adapter.RandomLottoNumbersProvider;
import lotto.controller.LottoGameController;
import lotto.port.InputPort;
import lotto.port.OutputPort;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        InputPort inputPort = new ConsoleInputAdapter();
        OutputPort outputPort = new ConsoleOutputAdapter();
        LottoService lottoService = new LottoService(new RandomLottoNumbersProvider());

        LottoGameController lottoGameController = new LottoGameController(inputPort,outputPort, lottoService);

        lottoGameController.playGame();
    }
}
