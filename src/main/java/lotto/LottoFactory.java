package lotto;

import lotto.adapter.ConsoleInputAdapter;
import lotto.adapter.ConsoleOutputAdapter;
import lotto.adapter.RandomLottoNumbersProvider;
import lotto.adapter.printer.LottoPrinter;
import lotto.adapter.view.LottoGameView;
import lotto.controller.LottoGameController;
import lotto.domain.LottoMachine;
import lotto.port.InputPort;
import lotto.port.OutputPort;
import lotto.service.LottoNumberGenerationService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultCalculationService;
import lotto.service.LottoWinningNumberService;

public class LottoFactory {

    public static LottoGameView createLottoGameView() {
        InputPort inputPort = new ConsoleInputAdapter();
        OutputPort outputPort = new ConsoleOutputAdapter();
        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumbersProvider());
        LottoNumberGenerationService lottoNumberGenerationService = new LottoNumberGenerationService(lottoMachine);
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        LottoResultCalculationService lottoResultCalculationService = new LottoResultCalculationService(outputPort);
        LottoWinningNumberService lottoWinningNumberService = new LottoWinningNumberService();
        LottoGameController lottoGameController = new LottoGameController(lottoNumberGenerationService, lottoPurchaseService,
                lottoResultCalculationService, lottoWinningNumberService);
        LottoPrinter lottoPrinter = new LottoPrinter(outputPort);
        return new LottoGameView(inputPort, outputPort, lottoGameController, lottoPrinter);
    }
}
