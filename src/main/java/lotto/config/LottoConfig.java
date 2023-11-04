package lotto.config;

import lotto.service.LottoPublishService;
import lotto.service.LottoPublishServiceImpl;

public class LottoConfig {

    public static LottoPublishService lottoPublishService() {
        return new LottoPublishServiceImpl();
    }
}
