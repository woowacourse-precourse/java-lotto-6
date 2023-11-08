package lotto.controller;

import lotto.domain.Buy;
import lotto.domain.LottoList;
import lotto.domain.WinningLotto;
import lotto.service.InputService;
import lotto.service.LottoService;

public class Controller {
    private final InputService inputService;
    private final LottoService lottoService;

    public Controller() {
        this.inputService = new InputService();
        this.lottoService = new LottoService();
    }

    public void playGame() {
        Buy buy = inputService.enterMoney();
        LottoList lottoList = lottoService.createLottoList(buy.getCount());
        lottoService.printAllLottoNumber(lottoList);
        WinningLotto winningLotto = inputService.enterWinningLotto();
        lottoService.judgeLotto(lottoList, winningLotto);
        lottoService.printResult();
        lottoService.calculateEarningRate(buy.getMoney());
    }

}
