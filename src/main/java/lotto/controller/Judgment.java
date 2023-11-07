package lotto.controller;

import java.util.List;

public class Judgment {
    public int correctCount(List<Integer> computer, List<Integer> buyer){
        computer.retainAll(buyer);
        int result = computer.size();
        return result;
    }

    public boolean correctBonus(List<Integer> computer, int bonusnumber){
        if(computer.contains(bonusnumber)){
            return true;
        }
        return false;
    }
}
