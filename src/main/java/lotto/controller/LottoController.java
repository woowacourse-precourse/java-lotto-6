package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoShop;
import lotto.view.View;

public class LottoController {

    private final View view;
    private final LottoShop lottoShop;

    public LottoController(View view) {
        this.view = view;
        this.lottoShop = new LottoShop();
    }

    public void run() {
        int money = view.getMoney();
        List<Lotto> lottos = lottoShop.buy(money);
        view.printLottosInfo(lottos);
    }
}
