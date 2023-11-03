package lotto.controller;

import lotto.domain.AmountLotto;
import lotto.domain.RankingLotto;
import lotto.domain.MyLottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;

public class LottoController {
    public void start(){
        startLottoGame();
    }

    private void startLottoGame(){
        AmountLotto amountLotto = new AmountLotto();
        MyLottos myLottos = new MyLottos();
        WinningLotto winningLotto = new WinningLotto();
        settingLottoGame(myLottos,amountLotto,winningLotto);
        HashMap<RankingLotto, Integer> lottoRank = RankingLotto.makeHashMapLottoRanking();
        int money = 0;

        for(int i = 0 ; i < amountLotto.calculateAmountLotto(); i++){
            RankingLotto rankingLotto = winningLotto.matchLotto(myLottos.getLottos().get(i));
            String reward = rankingLotto.getReward().replace(",", "");
            money += Integer.parseInt(reward);
            lottoRank.put(rankingLotto, lottoRank.get(rankingLotto)+1);
        }
        double profitPercentage = ((double)money / (double)amountLotto.getAmount() * 100);
        OutputView.winningResult(lottoRank);
        OutputView.printLottoYield(profitPercentage);

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
