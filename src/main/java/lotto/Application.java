package lotto;

import java.util.List;
import lotto.Service.BuyLottoService;
import lotto.Service.CompareService;
import lotto.Service.InputNumberService;
import lotto.Service.InputPurchasePriceService;
import lotto.Service.StatisticsService;
import lotto.controller.BuyLottoController;
import lotto.controller.CompareController;
import lotto.controller.InputNumberController;
import lotto.controller.InputPurchasePriceController;
import lotto.controller.StatisticsController;
import lotto.dto.LottoResults;
import lotto.dto.WinnerAndBonusNumber;
import lotto.model.PurchasePrice;
import lotto.model.Statistics;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.InputView;
import lotto.view.input.Template.InputValidatorTemplate;
import lotto.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        PurchasePriceValidator purchasePriceValidator = new PurchasePriceValidator();
        WinnerNumberValidator winnerNumberValidator = new WinnerNumberValidator();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        InputValidatorTemplate template = new InputValidatorTemplate();

        InputView inputView = new InputView(purchasePriceValidator, winnerNumberValidator, bonusNumberValidator,
                template);
        OutputView outputView = new OutputView();

        InputPurchasePriceService inputPurchasePriceService = new InputPurchasePriceService(inputView, outputView);
        InputPurchasePriceController inputPurchasePriceController = new InputPurchasePriceController(
                inputPurchasePriceService);

        BuyLottoService buyLottoService = new BuyLottoService(outputView);
        BuyLottoController buyLottoController = new BuyLottoController(buyLottoService);

        InputNumberService inputNumberService = new InputNumberService(inputView, outputView);
        InputNumberController inputNumberController = new InputNumberController(inputNumberService);

        CompareService compareService = new CompareService();
        CompareController compareController = new CompareController(compareService);

        StatisticsService statisticsService = new StatisticsService(outputView);
        StatisticsController statisticsController = new StatisticsController(statisticsService);

        PurchasePrice purchasePrice = inputPurchasePriceController.purchasePrice();
        LottoResults lottoResults = buyLottoController.buyLotto(purchasePrice);
        WinnerAndBonusNumber winnerAndBonusNumber = inputNumberController.inputNumber();
        List<Statistics> result = compareController.compareNumber(lottoResults, winnerAndBonusNumber);
        statisticsController.getStatics(result, purchasePrice);
    }
}
