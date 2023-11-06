package controller;

import model.*;

public class PrizeChecker {
    //당첨관련 클래스

    public Ranking checkRank(Lottos lottos, PrizeNumber prizeNumber){
        Ranking ranking = new Ranking();
        for(Lotto lotto : lottos.getLottos()){
            ranking.addRank(checkAnswer(lotto,prizeNumber));
        }
        return ranking;
    }

    private int checkAnswer(Lotto lotto, PrizeNumber prizeNumber){
        int count = 0;
        count = lotto.checkMatch(prizeNumber.getPrizeNumber());
        if(count == 5 && lotto.checkBonus(prizeNumber.getBonousNumber())){
            count += 2;
        }
        return count;
    }

    private void calculateYield(){

    }
}
