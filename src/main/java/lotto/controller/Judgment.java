package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.LottoInfo;

public class Judgment {
    static LottoInfo lottoinfo = new LottoInfo();

    public void correctCount(List<Integer> computer, List<Integer> buyer){
        List<Integer> computercopy = new ArrayList<>(computer);
        computercopy.retainAll(buyer);
        int result = computercopy.size();
        
        lottoinfo.setCorrectCount(result);
    }

    public boolean correctBonus(List<Integer> computer, Integer bonusnumber){
        for(int i : computer){
            if (i == bonusnumber){
                return true;
            }
        }
        return false;
    }
}
