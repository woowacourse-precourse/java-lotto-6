package lotto;

import static lotto.util.ModelAndViewConverter.getModelAndViewConverter;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.service.LottoPurchaseService;
import lotto.domain.service.LottoResultsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController getLottoController() {
        return new LottoController(inputView(), outputView(), getModelAndViewConverter(), lottoPurchaseService(),
                lottoResultsService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView(getModelAndViewConverter());
    }

    private LottoPurchaseService lottoPurchaseService() {
        return new LottoPurchaseService(lottoBundle());
    }

    private LottoBundle lottoBundle() {
        return new LottoBundle();
    }

    private LottoResultsService lottoResultsService() {
        return new LottoResultsService(lottoResultsRepository());
    }

    private LottoResultsRepository lottoResultsRepository() {
        return new LottoResultsRepository();
    }

    public void endLottoGame() {
        Console.close();
    }
}
