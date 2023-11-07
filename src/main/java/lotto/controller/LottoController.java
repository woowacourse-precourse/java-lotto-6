package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoService lottoService;

    public void playLotto(){
        lottoService.setMoney(inputView.getMoney());
        lottoService.buyLotto();
        outputView.printLotto(lottoService.getUser());
        lottoService.setWinningNumbers(inputView.getWinningNumbers());
    }
}
