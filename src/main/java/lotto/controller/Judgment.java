package lotto.controller;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    public int correctCount(List<Integer> computer, List<Integer> buyer){
        List<Integer> computercopy = new ArrayList<>(computer);
        computercopy.retainAll(buyer);
        int result = computercopy.size();
        return result;
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
