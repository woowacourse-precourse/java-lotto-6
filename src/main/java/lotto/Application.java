package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoNumberGeneratorService;
import lotto.service.LottoRankCalculatorService;
import lotto.service.LottoStoreService;
import lotto.view.InputReader;
import lotto.view.InputView;
import lotto.view.MessageResolver;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView(new InputReader());
        OutputView outputView = new OutputView(new MessageResolver());
        LottoRankCalculatorService lottoRankCalculatorService = new LottoRankCalculatorService();
        LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
        LottoGeneratorService lottoGeneratorService = new LottoGeneratorService(lottoNumberGeneratorService);
        LottoStoreService lottoStoreService = new LottoStoreService(lottoGeneratorService);

        LottoGameController lottoGameController = new LottoGameController(inputView, outputView, lottoStoreService,
                lottoRankCalculatorService);

        lottoGameController.run();
    }
}
