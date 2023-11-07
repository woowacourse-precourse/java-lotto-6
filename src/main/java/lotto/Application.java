package lotto;

import lotto.adapter.ConsoleInputAdapter;
import lotto.adapter.ConsoleOutputAdapter;
import lotto.adapter.RandomLottoNumbersProvider;
import lotto.controller.LottoGameController;
import lotto.port.InputPort;
import lotto.port.OutputPort;
import lotto.service.LottoNumberGenerationService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultCalculationService;
import lotto.service.LottoWinningNumberService;


public class Application {
    public static void main(String[] args) {
        InputPort inputPort = new ConsoleInputAdapter();
        OutputPort outputPort = new ConsoleOutputAdapter();
        LottoNumberGenerationService lottoNumberGenerationService = new LottoNumberGenerationService(new RandomLottoNumbersProvider());
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        LottoResultCalculationService lottoResultCalculationService = new LottoResultCalculationService();
        LottoWinningNumberService lottoWinningNumberService = new LottoWinningNumberService();
        LottoGameController lottoGameController = new LottoGameController(inputPort,outputPort,lottoNumberGenerationService,lottoPurchaseService,lottoResultCalculationService,lottoWinningNumberService);

        lottoGameController.playGame();
    }
}
