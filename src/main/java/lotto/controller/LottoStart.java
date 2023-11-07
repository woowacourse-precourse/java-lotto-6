package lotto.controller;

import java.util.List;

import lotto.Lotto;
import lotto.model.WinningInfo;

public class LottoStart {
    static Lotto lotto;
    static Judgment judgment = new Judgment();
    static NumberGenerator numbergenerator = new NumberGenerator();
    WinningInfo winninginfo = new WinningInfo();

    public LottoStart(){
        final int num = numbergenerator.inputBuyCost();
        final int num1 = numbergenerator.createUnitLotto(num);
        final List<List<Integer>> num2 = numbergenerator.createLottoNumbers(num1);
        lottonumbers(num2);
        correctNumberSet();
        
        int bonusNumber = numbergenerator.InputBonusNumber(lotto.getLotto());
        
        for(List<Integer> st : num2){
            int correctCount = judgment.correctCount(st , lotto.getLotto());
            setWinningInfo(correctCount);
        }
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

    private void setWinningInfo(int correctCount){
        if (correctCount == 3){
            winninginfo.setFifthRank();
        }
        else if (correctCount == 4){
            winninginfo.setfourthrank();
        }
        else if (correctCount == 5){
            winninginfo.setthirdrank();
        }
        else if (correctCount == 6){
            winninginfo.setfirstrank();
        }
    }
}
