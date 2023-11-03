package lotto.Logic;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    first(2000000000,6,0),
    second(30000000,5,1),
    third(15000005,5,0),
    fourth(50000,4,0),
    fifth(5000,3,0),
    sixth(0,0,0);

    private int winningPrize;
    private List<Integer> judge;
    //private List<Integer> memberResult;

    Prize(int winningPrize,int correct,int bonus){
        this.winningPrize=winningPrize;
        this.judge=new ArrayList<>();
        this.judge.add(correct);
        this.judge.add(bonus);
    }

    public int getWinningPrize(){
        return this.winningPrize;
    }

    public Prize prizeDetermine(List<Integer> correctBonus){

        for(Prize p : Prize.values()){//여기서 p 활용

            if (p.judge.equals(correctBonus))
                return p;
        }
        return Prize.sixth;
    }

}
