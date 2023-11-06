package lotto;

import java.util.List;
import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.controller.PlayerController;
import lotto.domain.Lotto;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        PlayerController playerController = appConfig.playerController();
        LottoController lottoController = appConfig.lottoController();

        List<Lotto> purchaseLotto;
        while (true) {
            try {
                View.printStartMessage();
                purchaseLotto = playerController.purchaseLotto(View.input());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        View.printPurchaseMessage(purchaseLotto.size());
        View.printPurchasedLotto(purchaseLotto);

        while (true) {
            try {
                View.printLottoResult(lottoController.inputNumbers(View.printInputNumbersMessage()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        View.printRateOfReturn(playerController.calculateRateOfReturn());
    }
}
