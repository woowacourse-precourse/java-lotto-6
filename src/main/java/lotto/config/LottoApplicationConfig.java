package lotto.config;

import lotto.service.LottoService;
import lotto.service.WinningService;
import lotto.utils.NumberGenerator;

public class LottoApplicationConfig {

    public LottoService createLottoService() {
        NumberGenerator numberGenerator = new NumberGenerator();
        return new LottoService(numberGenerator);
    }

    public WinningService createWinningService() {
        return new WinningService();
    }
}
