package lotto;

import lotto.controller.BonusNumberService;
import lotto.controller.LottoGameController;
import lotto.controller.PurchasedLottoService;
import lotto.controller.WinningLottoService;

public class Application {
    public static void main(String[] args) {
        PurchasedLottoService purchasedLottoService = new PurchasedLottoService();
        WinningLottoService winningLottoService = new WinningLottoService();
        BonusNumberService bonusNumberService = new BonusNumberService();

        LottoGameController lottoGameController = new LottoGameController(purchasedLottoService, winningLottoService, bonusNumberService);
        lottoGameController.run();
    }
}
