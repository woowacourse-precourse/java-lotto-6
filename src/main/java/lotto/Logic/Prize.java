package lotto.Logic;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    first(2000000000,6,0,0),
    second(30000000,5,1,1),
    third(15000005,5,0,2),
    fourth(50000,4,0,3),
    fifth(5000,3,0,4),
    sixth(0,0,0,5);

    private int winningPrize;
    private List<Integer> judge;
    private int count;


    Prize(int winningPrize,int correct,int bonus,int count){
        this.winningPrize=winningPrize;

        this.judge=new ArrayList<>();
        this.judge.add(correct);
        this.judge.add(bonus);

        this.count=count;
    }

    public int getCount(){
        return this.count;
    }
    public int getWinningPrize(){
        return this.winningPrize;
    }

    public Prize prizeDetermine(List<Integer> correctBonus){

        for(Prize p : Prize.values()){

            if (p.judge.equals(correctBonus))
                return p;
        }
        return Prize.sixth;
    }

}
