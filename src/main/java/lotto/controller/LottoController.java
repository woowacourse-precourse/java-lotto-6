package lotto.controller;

import lotto.Service.LottoService;
import lotto.domain.LottoBuy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        String buyMoney = InputView.buyMoney();
        LottoService lottoService = new LottoService();
        LottoBuy lottoBuy = new LottoBuy(buyMoney, lottoService.calLottoNum(buyMoney));
        int lottoNum = lottoBuy.getLottoNum();
        OutputView.lottoNum(lottoNum);


    }
}
