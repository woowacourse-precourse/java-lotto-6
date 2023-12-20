package lotto;

import lotto.repository.ResultRepository;
import lotto.service.LottoService;

public class ApplicationConfig {

    public LottoService lottoService() {
        return new LottoService(resultRepository());
    }

    public ResultRepository resultRepository() {
        return new ResultRepository();
    }
}
