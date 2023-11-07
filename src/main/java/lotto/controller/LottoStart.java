package lotto.controller;

import java.util.List;

import lotto.Lotto;

public class LottoStart {
    static Lotto lotto;
    static Judgment judgment = new Judgment();
    static NumberGenerator numbergenerator = new NumberGenerator();

    public LottoStart(){
        final int num = numbergenerator.inputBuyCost();
        final int num1 = numbergenerator.createUnitLotto(num);
        final List<List<Integer>> num2 = numbergenerator.createLottoNumbers(num1);
        lottonumbers(num2);
        correctNumberSet();
        
        for(List<Integer> st : num2){
            int num5 = judgment.correctCount(st , lotto.getLotto());
            System.out.println(num5);
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
}
