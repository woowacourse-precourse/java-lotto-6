package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.RandomNumberGenerator;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.View;

public class AppConfig {

    public Controller controller() {
        return new Controller(lottoService(), view());
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoNumberGenerator());
    }

    public LottoNumberGenerator lottoNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public View view() {
        return new View();
    }
}
