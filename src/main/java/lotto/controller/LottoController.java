package lotto.controller;

import lotto.domain.AmountLotto;
import lotto.domain.MyLottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start(){
        startLottoGame();
    }

    private void startLottoGame(){
        AmountLotto amountLotto = new AmountLotto();
        MyLottos myLottos = new MyLottos(amountLotto.calculateAmountLotto());
        OutputView.printPurchaseLottoNumber(myLottos.getLottos().size(), myLottos);

        WinningLotto winningLotto = new WinningLotto();

        initializeLottoGame(amountLotto,winningLotto);
    }

    private void initializeLottoGame(AmountLotto amountLotto, WinningLotto winningLotto) {
        requestAmountLotto(amountLotto);
        requestWinningLotto(winningLotto);
        requestWinningBonus(winningLotto);
    }

    public void requestAmountLotto(AmountLotto amountLotto){
        try{
            amountLotto.responseAmountLotto(InputView.lottoPurchaseAmountInput());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            requestAmountLotto(amountLotto);
        }
    }
    public void requestWinningLotto(WinningLotto winningLotto){
        try{
            winningLotto.convertWinningLotto(InputView.winningLottoInput());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            requestWinningLotto(winningLotto);
        }
    }
    public void requestWinningBonus(WinningLotto winningLotto){
        try{
            winningLotto.convertWinningBonus(InputView.bonusLottoInput());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            requestWinningBonus(winningLotto);
        }
    }




}
