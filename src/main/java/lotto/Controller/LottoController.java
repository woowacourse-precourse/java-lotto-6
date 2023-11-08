package lotto.Controller;

import lotto.Model.*;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    LottoPrice lottoPrice = new LottoPrice();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    WinningLotto winningLotto = new WinningLotto();
    Validation validation = new Validation();
    private LottoPublish lottoPublish;
    private BonusNumber bonusNumber;
    private int amount;
    Lotto lotto;

    public void gameStart(){
        inputBuyLotto();
        publishedLottoList();
        outputLottoPublished();
        inputWinningNumber();
        inputBonusNumber();
        outputWinningCount();
        outputPrefix();

    }
    private void publishedLottoList(){
        this.lottoPublish = new LottoPublish(amount);
    }
    private void outputLottoPublished(){
        outputView.printPurchaseTicket(amount,lottoPublish.getLottoPublish());
    }

    private void outputPrefix(){
        outputView.printTotalPrefix(winningLotto.calculateMoney(amount));
    }
    private void outputWinningCount(){
        winningLotto.FindMatchNumber(lottoPublish.getLottoPublish()
        ,lotto.getNumbers(), bonusNumber.getBonusNumber());
        outputView.printWinningCount(winningLotto.getWinningCount());
    }
    private void inputWinningNumber(){
        try {
            lotto = new Lotto(validation.isChecktLotto(inputView.getWinningNumber()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputWinningNumber();
        }
    }

    private void inputBonusNumber(){
        try {
            bonusNumber= new BonusNumber(validation.isCheckNumber(inputView.getBonusNumber()),lotto.getNumbers());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
    }

    private void inputBuyLotto(){
        try {
            amount = lottoPrice.initLottoPrice(validation.isCheckNumber(inputView.getUserMoney()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBuyLotto();
        }
    }
}
