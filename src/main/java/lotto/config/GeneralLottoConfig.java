package lotto.config;

import lotto.controller.LottoController;
import lotto.random.GeneralRandomNumberGenerator;
import lotto.random.RandomNumberGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GeneralLottoConfig implements LottoConfig {

    //TODO: 메서드 순서 변경
    @Override
    public RandomNumberGenerator randomNumberGenerator() {
        return new GeneralRandomNumberGenerator();
    }

    @Override
    public LottoService lottoService() {
        return new LottoService(randomNumberGenerator());
    }

    @Override
    public InputView inputView() {
        return new InputView();
    }

    @Override
    public OutputView outputView() {
        return new OutputView();
    }

    @Override
    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView(), outputView());
    }
}
