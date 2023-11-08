package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRanking {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FORTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    OTHER(0,0,"");

    private static final Integer MINIMUM_WINNING_COUNT = 3;
    private final Integer countLottoMatched;
    private final Integer winningMoney;
    private final String winningMessage;

    LottoRanking(Integer countLottoMatched, Integer winningMoney, String winningMessage){
        this.countLottoMatched = countLottoMatched;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
    }

    public Integer getCountLottoMatched() {
        return countLottoMatched;
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public static LottoRanking getRanking(Integer countAboutLotto, Boolean isMatchBonus){
        if(countAboutLotto.equals(SECOND.getCountLottoMatched()) && isMatchBonus){
            return SECOND;
        }
        for(LottoRanking ranking : values()){
            if(ranking.equals(SECOND)){
                continue;
            }else if(countAboutLotto.equals(ranking.getCountLottoMatched())){
                return ranking;
            }
        }
        return OTHER;
    }
}
