package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoGameResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private Buyer buyer;
    private LottoGame lottoGame;
    private Lotto lotto;


    public void run(){
        initBuyer();
        printBuyersLotto();
        initLottoGame();
        ranking();
    }

    private void initBuyer(){
        int amount = InputView.readAmount();
        buyer = new Buyer(amount);
    }

    private void initLottoGame(){
        getWinningNumbers();
        getBonus();
    }

    private void printBuyersLotto(){
        buyer.printLotto();
    }

    private void getWinningNumbers(){
        try {
            lotto = new Lotto(InputView.readWinningNumbers());
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            getWinningNumbers();
        }
    }

    private void getBonus(){
        try{
            int bonus = InputView.readBonus();
            lottoGame = new LottoGame(bonus, lotto);
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            getBonus();
        }
    }

    private void ranking(){
        LottoGameResult lottoGameResult = lottoGame.checkGameResult(buyer.getLottoNumbers());
    }
}
