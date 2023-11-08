package lotto;

import lotto.adapter.ConsoleInputAdapter;
import lotto.adapter.ConsoleOutputAdapter;
import lotto.adapter.LottoPrinter;
import lotto.adapter.RandomLottoNumbersProvider;
import lotto.controller.LottoGameController;
import lotto.domain.LottoMachine;
import lotto.port.InputPort;
import lotto.port.OutputPort;
import lotto.service.LottoNumberGenerationService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultCalculationService;
import lotto.service.LottoWinningNumberService;

public class LottoFactory {

    public static LottoGameController createLottoGameView() {
        InputPort inputPort = new ConsoleInputAdapter();
        OutputPort outputPort = new ConsoleOutputAdapter();
        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumbersProvider());
        LottoNumberGenerationService lottoNumberGenerationService = new LottoNumberGenerationService(lottoMachine);
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        LottoResultCalculationService lottoResultCalculationService = new LottoResultCalculationService(outputPort);
        LottoWinningNumberService lottoWinningNumberService = new LottoWinningNumberService();
        LottoPrinter lottoPrinter = new LottoPrinter(outputPort);
        return new LottoGameController(inputPort, outputPort,lottoNumberGenerationService, lottoPurchaseService,
                lottoResultCalculationService, lottoWinningNumberService,lottoPrinter);
    }
}
