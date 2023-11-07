package lotto.controller;

import java.util.List;

import lotto.Lotto;
import lotto.model.WinningInfo;
import lotto.view.OutputView;

public class LottoStart {
    static Lotto lotto;
    static Judgment judgment = new Judgment();
    static NumberGenerator numbergenerator = new NumberGenerator();
    static WinningInfo winninginfo = new WinningInfo();
    static OutputView outputview = new OutputView();

    public LottoStart(){
        final int buycost = numbergenerator.inputBuyCost();
        final int buycount = numbergenerator.createUnitLotto(buycost);
        final List<List<Integer>> lottonumbers = numbergenerator.createLottoNumbers(buycount);
        lottonumbers(lottonumbers);
        correctNumberSet();
        
        int bonusNumber = numbergenerator.InputBonusNumber(lotto.getLotto());
        
        for(List<Integer> i : lottonumbers){
            int correctCount = judgment.correctCount(i , lotto.getLotto());
            setWinningInfo(i, correctCount, bonusNumber);
        }

        outputview.getEndLotto(winninginfo, buycost);
    }

    public void lottonumbers(List<List<Integer>> numbers){
        for(List<Integer> i : numbers){
            System.out.println(i);
        }
    }

    public void correctNumberSet(){
        boolean end = true;
        while(end){
            try{
                String[] num3 = numbergenerator.InputCorrectLotto();
                final List<Integer> num4 = numbergenerator.conversionInputToInteger(num3);
                lotto = new Lotto(num4);
                end = false;
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }   
        }
    }

    private void setWinningInfo(List<Integer> lottonumbers , int correctCount, int bonusNumber){
        if (correctCount == 3){
            winninginfo.setFifthRank();
        }
        else if (correctCount == 4){
            winninginfo.setfourthrank();
        }
        else if(correctCount == 5 && judgment.correctBonus(lottonumbers, bonusNumber)){
            winninginfo.setsecondrank();
        }
        else if (correctCount == 5){
            winninginfo.setthirdrank();
        }
        else if (correctCount == 6){
            winninginfo.setfirstrank();
        }
    }
}
