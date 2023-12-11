package lotto;

import lotto.config.Configuration;
import lotto.controller.BuyLottoController;
import lotto.controller.LottoController;
import lotto.dto.BuyLottoDto;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        LottoController lottoController = configuration.getLottoController();
        BuyLottoController buyLottoController = configuration.getBuyLottoController();
        executeControllers(buyLottoController, lottoController);
    }

    private static void executeControllers(BuyLottoController buyLottoController, LottoController lottoController) {
        BuyLottoDto buyLottoDto = buyLottoController.buyLotto();
        lottoController.getStatistics(buyLottoDto);
    }
}
