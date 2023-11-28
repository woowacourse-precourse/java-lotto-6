package lotto;

import lotto.controller.LottoController;
import lotto.service.BuyLottoService;
import lotto.service.CalculateStatisticService;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.InputView;
import lotto.view.input.template.InputValidatorTemplate;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // 객체 생성
        InputView inputView = createInputView();
        OutputView outputView = new OutputView();

        BuyLottoService buyLottoService = createBuyLottoService(outputView);
        CalculateStatisticService calculateStatisticService = createCalculateStatisticService(outputView);

        LottoController lottoController = createLottoController(inputView, outputView, buyLottoService,
                calculateStatisticService);

        // 메서드 호출
        executeControllers(lottoController);
    }

    private static InputView createInputView() {
        PurchasePriceValidator purchasePriceValidator = new PurchasePriceValidator();
        WinnerNumberValidator winnerNumberValidator = new WinnerNumberValidator();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        InputValidatorTemplate template = new InputValidatorTemplate();
        return new InputView(purchasePriceValidator, winnerNumberValidator, bonusNumberValidator, template);
    }

    private static BuyLottoService createBuyLottoService(OutputView outputView) {
        return new BuyLottoService(outputView);
    }


    private static CalculateStatisticService createCalculateStatisticService(OutputView outputView) {
        return new CalculateStatisticService(outputView);
    }


    private static LottoController createLottoController(InputView inputView,
                                                         OutputView outputView,
                                                         BuyLottoService buyLottoService,
                                                         CalculateStatisticService calculateStatisticService) {
        return new LottoController(inputView, outputView, buyLottoService, calculateStatisticService);
    }

    private static void executeControllers(LottoController lottoController) {
        lottoController.run();
    }
}
