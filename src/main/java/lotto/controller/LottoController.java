package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private UserCount userCount;
    private LottoList lottoList;
    public LottoController(){
        start();
    }
    public void start(){
        int count = inputBuyLotto();
        OutputView.printCount(count);
        lottoList = makeLottolist(count);
        Lotto winningLotto = inputWinningLotto();
        winningLotto = inputBonusLotto(winningLotto);
        double rate = rateCalculate(resultLotto(winningLotto), count);
        OutputView.printTotalReturn(rate);
    }
    public int inputBuyLotto(){
        try{
            userCount = new UserCount(InputView.inputLottoAmount());
            return userCount.getCount();
        }
        catch (IllegalArgumentException e){
            return inputBuyLotto();
        }
    }
    public LottoList makeLottolist(int count){
        for(int i=0; i<count; i++){
            lottoList = new LottoList(makeLotto());
        }
        return lottoList;
    }
    public Lotto makeLotto(){
        List<Integer> lottoNum = new ArrayList<>();
        AutoLotto autoLotto = new AutoLotto();
        lottoNum = autoLotto.getAutoLotto();
        OutputView.printLotto(lottoNum);
        return new Lotto(lottoNum);
    }
    public Lotto inputWinningLotto(){
        try{
            Lotto winningLotto = new Lotto(InputView.inputWinningNumber());
            return winningLotto;
        }
        catch (IllegalArgumentException e){
            return inputWinningLotto();
        }

    }
    public Lotto inputBonusLotto(Lotto winningLotto){
        try{
            winningLotto.setBonusNumber(InputView.BonusNumber());
            return winningLotto;

        }
        catch (IllegalArgumentException e){
            return inputBonusLotto(winningLotto);
        }
    }
    public int resultLotto(Lotto winningLotto){
        List<Integer> winningCountList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        OutputView.printResult();
        int totalPrice = 0;
        for(Lotto lotto : lottoList.getLottoList()){
            int cnt = lotto.match(winningLotto);
            WinningRank winningRank = WinningRank.resultLotto(cnt, lotto.containNumber(winningLotto.getBonusNumber()));
            totalPrice+= winningRank.getReward();

             if(winningRank==WinningRank.FIFTH){
                 winningCountList.set(0, winningCountList.get(0)+1);
             }
             if(winningRank==WinningRank.FOURTH){
                 winningCountList.set(1, winningCountList.get(1)+1);
             }
             if(winningRank==WinningRank.THIRD){
                 winningCountList.set(2, winningCountList.get(2)+1);
             }
             if(winningRank==WinningRank.SECOND){
                 winningCountList.set(3, winningCountList.get(3)+1);
             }
             if(winningRank==WinningRank.FIRTH){
                 winningCountList.set(4, winningCountList.get(4)+1);
             }

        }
        OutputView.printRanking(winningCountList);
        return totalPrice;
    }
    public double rateCalculate(int totalPrice, int count){
        return (double) totalPrice/(count*1000)*100;
    }

}
