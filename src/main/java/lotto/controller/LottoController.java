package lotto.controller;

import lotto.domain.AmountLotto;
import lotto.domain.LottoRanking;
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
        MyLottos myLottos = new MyLottos();
        WinningLotto winningLotto = new WinningLotto();
        LottoRanking lottoRanking = new LottoRanking();

        settingLottoGame(myLottos,amountLotto,winningLotto);

        matchLotto(amountLotto, myLottos, winningLotto, lottoRanking);
        OutputView.winningResult(lottoRanking);
    }


    private void matchLotto(AmountLotto amountLotto, MyLottos myLottos, WinningLotto winningLotto, LottoRanking lottoRanking) {
        for(int i = 0 ; i < myLottos.getLottos().size(); i++){
            int matchCount = myLottos.getLottos().get(i).countMatch(winningLotto.getLotto());
            boolean matchBouns = myLottos.getLottos().get(i).containMatch(winningLotto.getBonus());

            lottoRanking.checkRanking(matchCount, matchBouns);

        }
    }

    private void settingLottoGame(MyLottos myLottos ,AmountLotto amountLotto, WinningLotto winningLotto) {
        requestAmountLotto(amountLotto);
        requestCreateMyLotto(myLottos, amountLotto);
        requestWinningLotto(winningLotto);
        requestWinningBonus(winningLotto);
    }

    private void requestCreateMyLotto(MyLottos myLottos,AmountLotto amountLotto) {
        myLottos.responseCreateMyLottos(amountLotto.calculateAmountLotto());
        OutputView.printPurchaseLottoNumber(myLottos.getLottos().size(), myLottos);
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
