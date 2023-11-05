package lotto.controller;

import lotto.Service.LottoService;
import lotto.domain.LottoBuy;
import lotto.domain.LottoSet;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        LottoService lottoService = new LottoService();

        String buyMoney = InputView.InputBuyMoney();
        LottoBuy lottoBuy = new LottoBuy(buyMoney, lottoService.calLottoNum(buyMoney));
        int lottoNum = lottoBuy.getLottoNum();
        OutputView.outputLottoNum(lottoNum);

        LottoSet lottoSet = new LottoSet(lottoService.generateLottoSet(lottoNum));
        OutputView.outputLottoSet(lottoSet);
    }
}
