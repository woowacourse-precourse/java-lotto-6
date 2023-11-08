package lotto.controller;

import lotto.domain.*;
import lotto.util.ExceptionMessage;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    public void startGame(){
        PurchaseLotto purchaseLotto = initPurchase();
        LottoGame lottoGame = initLottoGame();
        getResult(lottoGame, purchaseLotto);
    }

    private PurchaseLotto initPurchase(){
        try{
            return purchaseLotto();
        }catch (IllegalArgumentException illegalArgumentException){
            ExceptionMessage.INPUT_WRONG_PURCHASE_MONEY_MESSAGE.getMessage();
            return initPurchase();
        }
    }

    private PurchaseLotto purchaseLotto(){
        PurchaseLotto purchaseLotto = new PurchaseLotto(getPurchaseMoney());
        OutputView.printPurchasedQuantity(purchaseLotto.getQuantity());
        OutputView.printPurchasedLottos(purchaseLotto.getPurchasedLottos());
        return purchaseLotto;
    }

    private LottoGame initLottoGame(){
        Lotto winningLotto = initWinningLotto();
        while(true){
            try{
                return new LottoGame(winningLotto, getBonusNumber());
            }catch (IllegalArgumentException illegalArgumentException){
                ExceptionMessage.INPUT_WRONG_BONUS_NUMBER_MESSAGE.getMessage();
            }
        }
    }

    private Lotto initWinningLotto(){
        try{
            return new Lotto(getWinningNumber());
        }catch (IllegalArgumentException illegalArgumentException){
            ExceptionMessage.INPUT_WRONG_WINNING_NUMBER_MESSAGE.getMessage();
            return initWinningLotto();
        }
    }

    private int getPurchaseMoney() throws IllegalArgumentException{
        return Parser.parseInt(InputView.getPurchaseMoney());
    }

    private List<Integer> getWinningNumber() throws IllegalArgumentException{
        return Parser.parseIntList(InputView.getWinningNumber());
    }

    private int getBonusNumber() throws IllegalArgumentException{
        return Parser.parseInt(InputView.getBonusNumber());
    }

    private void getResult(LottoGame lottoGame, PurchaseLotto purchaseLotto){
        WinningHistory winningHistory = new WinningHistory(lottoGame, purchaseLotto);
        OutputView.printWinningResult(winningHistory.getWinningResult());
        OutputView.printRateOfReturn(winningHistory.getRateOfReturn());
    }
}
