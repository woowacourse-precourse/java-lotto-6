package lotto.controller;

import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController(){
        lottoService = new LottoService();
        outputView = new OutputView();
    }

    public void playGame(){
        askUserToInsertMoneyToBuyLotto();
        lottoService.playGame();
    }

    private void askUserToInsertMoneyToBuyLotto(){
        outputView.askUserToInsertMoneyToBuyLotto();
    }
}