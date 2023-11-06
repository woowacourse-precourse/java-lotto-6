package lotto.controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
    private static final Map<String, BasicController> controllers = new HashMap<>();

    public FrontController() {
        controllers.put("pleaseEnterLottoPaymentMessage", new LottoPaymentController());
        controllers.put("pleaseEnterWinningNumbersMessage", new WinningNumbersController());
        controllers.put("pleaseEnterBonusNumberMessage", new BonusNumberController());
        controllers.put("informPurchasedLottosNumbersMessage", new GetNumberOfLottosController());
        controllers.put("printLottos", new PrintLottosController());
        controllers.put("printWinningResult", new PrintWinningResult());
    }

    public String match(String url, Map<String, Object> model) throws IllegalArgumentException {
        BasicController controller = controllers.get(url);
        return controller.handle(model);
    }
}
