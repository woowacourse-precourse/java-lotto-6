package lotto.config;

import lotto.controller.BuyLottoController;
import lotto.controller.LottoController;
import lotto.service.BuyLottoService;
import lotto.service.CalculateStatisticService;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.InputView;
import lotto.view.input.template.InputValidatorTemplate;
import lotto.view.output.OutputView;

public class Configuration {
    InputView inputView = createInputView();
    OutputView outputView = new OutputView();
    BuyLottoService buyLottoService = new BuyLottoService(outputView);
    CalculateStatisticService calculateStatisticService = new CalculateStatisticService(outputView);
    BuyLottoController buyLottoController = new BuyLottoController(inputView, outputView, buyLottoService);
    LottoController lottoController = new LottoController(inputView, outputView, calculateStatisticService);

    public BuyLottoController getBuyLottoController() {
        return buyLottoController;
    }

    public LottoController getLottoController() {
        return lottoController;
    }

    private InputView createInputView() {
        PurchasePriceValidator purchasePriceValidator = new PurchasePriceValidator();
        WinnerNumberValidator winnerNumberValidator = new WinnerNumberValidator();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        InputValidatorTemplate template = new InputValidatorTemplate();
        return new InputView(purchasePriceValidator, winnerNumberValidator, bonusNumberValidator, template);
    }
}
