package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoIssuer;
import lotto.service.LottoManager;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.WinningDetails;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager(
                new LottoIssuer(),
                new WinningDetails(),
                new ProfitRateCalculator()
        );
        LottoController lottoController = new LottoController(lottoManager);
        lottoController.run();
    }
}
