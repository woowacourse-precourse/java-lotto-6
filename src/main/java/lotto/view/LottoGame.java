package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Price;

public class LottoGame {

    private final LottoController lottoController = new LottoController();

    public LottoGame() {
        int lottoPrice = lottoController.LottoSetPrice();
        Price price = new Price(lottoPrice);
    }

}
