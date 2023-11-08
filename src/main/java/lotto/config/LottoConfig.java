package lotto.config;

import lotto.service.LottoPublishService;
import lotto.service.LottoPublishServiceImpl;
import lotto.service.WinningService;
import lotto.service.WinningServiceImpl;

public class LottoConfig {

    public static LottoPublishService lottoPublishService() {
        return new LottoPublishServiceImpl();
    }

    public static WinningService winningService() {
        return new WinningServiceImpl();
    }
}
