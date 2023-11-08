package lotto;

import lotto.config.LottoServices;
import lotto.config.LottoValidators;
import lotto.controller.LottoController;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.service.LottoSettingService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

public class LottoFactory {
    public LottoController createLottoController() {
        LottoSettingService settingService = new LottoSettingService();
        LottoPurchaseService purchaseService = new LottoPurchaseService();
        LottoService lottoService = new LottoService();
        LottoResultService resultService = new LottoResultService();
        PurchaseAmountValidator amountValidator = new PurchaseAmountValidator();
        WinningLottoValidator winningLottoValidator = new WinningLottoValidator();
        LottoServices lottoServices = new LottoServices(settingService, resultService,
                purchaseService, lottoService);
        LottoValidators lottoValidators = new LottoValidators(amountValidator, winningLottoValidator);

        return new LottoController(lottoServices, lottoValidators);
    }
}
