package lotto;

import lotto.controller.LottoService;
import lotto.controller.PriceService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        PriceService priceService = new PriceService(lottoService);
        lottoService.start();
        priceService.start();
    }
}
