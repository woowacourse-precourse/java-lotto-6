package lotto;

import lotto.repository.Result;
import lotto.service.LottoService;

public class ApplicationConfig {

    public LottoService lottoService() {
        return new LottoService(resultRepository());
    }

    public Result resultRepository() {
        return new Result();
    }
}
