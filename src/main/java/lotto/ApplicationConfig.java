package lotto;

import lotto.domain.Computer;
import lotto.service.LottoService;

public class ApplicationConfig {

    public LottoService lottoService() {
        return new LottoService(computer());
    }

    public Computer computer() {
        return new Computer();
    }
}
