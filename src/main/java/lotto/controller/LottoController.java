package lotto.controller;

import lotto.domain.*;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;

public class LottoController {
    public void start(){
        startLottoGame();
    }

    private void startLottoGame(){
        AmountLotto amountLotto =new AmountLotto(requestAmountLotto());
        MyLottos myLottos = new MyLottos();
        WinningLotto winningLotto = new WinningLotto(requestWinningLotto(), requestWinningBonus());
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
        requestCreateMyLotto(myLottos, amountLotto);
    }

    private void requestCreateMyLotto(MyLottos myLottos,AmountLotto amountLotto) {
        myLottos.responseCreateMyLottos(amountLotto.calculateAmountLotto());
        OutputView.printPurchaseLottoNumber(myLottos.getLottos().size(), myLottos);
    }

    public String requestAmountLotto(){
        try{
            return LottoValidator.amountInputValidator(InputView.lottoPurchaseAmountInput());
        }
        catch (IllegalArgumentException e){
            OutputView.printExceptionMessage(e.getMessage());
            return requestAmountLotto();
        }
    }
    public String requestWinningLotto(){
        try{
            return LottoValidator.winningLottoValidator(InputView.winningLottoInput());
        }
        catch (IllegalArgumentException e){
            OutputView.printExceptionMessage(e.getMessage());
            return requestWinningLotto();
        }
    }

    public String requestWinningBonus(){
        try{
            return LottoValidator.inputWinningBonusValidator(InputView.bonusLottoInput());
        }
        catch (IllegalArgumentException e){
            OutputView.printExceptionMessage(e.getMessage());
            return requestWinningBonus();
        }
    }
}
