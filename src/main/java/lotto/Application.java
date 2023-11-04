package lotto;

import java.util.List;
import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.controller.PlayerController;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.service.LottoService;
import lotto.service.PlayerService;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        PlayerController playerController = appConfig.playerController();
        LottoController lottoController = appConfig.lottoController();

        View.printStartMessage();
        List<Lotto> purchaseLotto = playerController.purchaseLotto(View.input());
        View.printPurchaseMessage(purchaseLotto.size());
        View.printPurchasedLotto(purchaseLotto);
        lottoController.inputNumbers(View.printInputNumbersMessage());
        View.printLottoResult();
    }
}
