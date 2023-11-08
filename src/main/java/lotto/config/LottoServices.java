package lotto.config;

import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.service.LottoSettingService;

public class LottoServices {
    public final LottoSettingService lottoSettingService;
    public final LottoResultService lottoResultService;
    public final LottoPurchaseService lottoPurchaseService;
    public final LottoService lottoService;

    public LottoServices(LottoSettingService lottoSettingService, LottoResultService lottoResultService, LottoPurchaseService lottoPurchaseService, LottoService lottoService) {
        this.lottoSettingService = lottoSettingService;
        this.lottoResultService = lottoResultService;
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoService = lottoService;
    }
}
