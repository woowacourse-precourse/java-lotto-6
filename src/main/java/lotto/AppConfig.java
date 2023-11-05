package lotto;

import static lotto.util.ModelAndViewConverter.getModelAndViewConverter;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController getLottoController() {
        return new LottoController(inputView(), outputView(), getModelAndViewConverter(), lottoResultsRepository());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView(getModelAndViewConverter());
    }

    private LottoResultsRepository lottoResultsRepository() {
        return new LottoResultsRepository();
    }

    public void endLottoGame() {
        Console.close();
    }
}
