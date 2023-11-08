package controller;

import model.*;

public class PrizeChecker {
    //당첨관련 클래스
    private final int CHECK_BONUS_NUMBER = 5;
    private final int SECOND_MATCH_NUMBER = 2;
    public Ranking checkRank(Lottos lottos, PrizeNumber prizeNumber) {
        Ranking ranking = new Ranking();
        for (Lotto lotto : lottos.getLottos()) {
            ranking.addRank(checkAnswer(lotto, prizeNumber));
        }
        return ranking;
    }

    private int checkAnswer(Lotto lotto, PrizeNumber prizeNumber) {
        int count = 0;
        count = lotto.checkMatch(prizeNumber.getPrizeNumber());
        if (count == CHECK_BONUS_NUMBER && lotto.checkBonus(prizeNumber.getBonousNumber())) {
            count += SECOND_MATCH_NUMBER;
        }
        return count;
    }

}
