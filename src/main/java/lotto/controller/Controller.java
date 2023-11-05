package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private Buyer buyer;
    private LottoGame lottoGame;
    private Lotto lotto;
    private int bonus;

    public void run(){
        initBuyer();
        printBuyersLotto();
        initLottoGame();
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
            bonus = InputView.readBonus();
            lottoGame = new LottoGame(bonus, lotto);
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            getBonus();
        }
    }
}
