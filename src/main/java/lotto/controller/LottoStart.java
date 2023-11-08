package lotto.controller;

import java.util.List;

import lotto.Lotto;
import lotto.model.LottoInfo;
import lotto.model.WinningInfo;
import lotto.view.OutputView;

public class LottoStart {
    static Lotto lotto;
    static Judgment judgment = new Judgment();
    static NumberGenerator numbergenerator = new NumberGenerator();
    static WinningInfo winninginfo = new WinningInfo();
    static OutputView outputview = new OutputView();
    static LottoInfo lottoinfo = new LottoInfo();

    public LottoStart(){
        numbergenerator.inputBuyCost();
        final int buycost = lottoinfo.getInputBuyCost();
        numbergenerator.createUnitLotto(buycost);
        final int buycount = lottoinfo.getCreateLottoNumber();
        numbergenerator.createLottoNumbers(buycount);
        final List<List<Integer>> lottonumbers = lottoinfo.getCreateLottoNumbers();

        lottonumbers(lottonumbers);
        correctNumberSet();
        
        numbergenerator.InputBonusNumber(lotto.getLotto());
        int bonusNumber = lottoinfo.getInputBonusNumber();
        compare(lottonumbers, bonusNumber);

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

    private void compare(List<List<Integer>> lottonumbers , int bonusNumber){
        for(List<Integer> i : lottonumbers){
            judgment.correctCount(i , lotto.getLotto());
            int correctCount = lottoinfo.getCorrectCount();
            setWinningInfo(i, correctCount, bonusNumber);
        }
    }
}
