package lotto;

import lotto.controller.BuyPriceController;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyPriceController buyPriceController = new BuyPriceController();
        buyPriceController.setBuyPrice();
        LottoController lottoController = new LottoController();
    }
}
