package lotto;

import lotto.repository.Result;
import lotto.service.LottoService;

public class ApplicationConfig {

    public LottoService lottoService() {
        return new LottoService(result());
    }

    public Result result() {
        return new Result();
    }
}
