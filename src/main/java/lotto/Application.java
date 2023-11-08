package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoMakeService;
import lotto.view.InputMapper;
import lotto.view.InputView;
import lotto.view.OutputMaker;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputMapper inputMapper = new InputMapper();
        InputView inputView = new InputView(inputMapper);
        OutputMaker outputMaker = new OutputMaker();
        OutputView outputView = new OutputView(outputMaker);
        LottoMakeService lottoMakeService = new LottoMakeService();
        LottoController lottoController = new LottoController(inputView, outputView,
            lottoMakeService);
        lottoController.run();
    }
}
