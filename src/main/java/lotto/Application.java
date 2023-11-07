package lotto;

import lotto.application.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        lottoService.sellLottos();
        lottoService.informPurchaseHistory();
        lottoService.requestWinningNumber();
        lottoService.showResult();
    }
}
