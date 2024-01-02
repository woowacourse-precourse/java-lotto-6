package lotto;

import lotto.model.LottoMachine;
import lotto.repository.Result;
import lotto.service.LottoService;

public class ApplicationConfig {

    public LottoService lottoService() {
        return new LottoService(result(), lottoMachine());
    }

    public Result result() {
        return new Result();
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine();
    }
}
