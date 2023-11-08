package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.domain.Price;

public class LottoGame {

    private final LottoController lottoController = new LottoController();

    public LottoGame() {
        int lottoPrice = lottoController.LottoSetPrice();
        Price price = new Price(lottoPrice);
    }

    public Lottos showLotto(Price price) {
        int boughtCount = price.getPrice()/1000;
        System.out.println(String.format("%d개를 구매했습니다.", boughtCount));
    }
}
