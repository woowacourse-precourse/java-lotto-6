package lotto.domain;

import lotto.view.LottoView;

public enum Ranking {

    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    private int countMatch;
    private int winningAmount;
    private String message;
    Ranking(int countMatch,int winningAmount,String message) {
        this.countMatch = countMatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public static Ranking valueOf(int countMatch,boolean matchBonus){
        if(countMatch < 3){
            return MISS;
        }

        if(SECOND.matchCount(countMatch) && matchBonus){
            return SECOND;
        }

        for(Ranking rank : values()){
            if(rank.matchCount(countMatch) && rank != SECOND){
                return rank;
            }
        }

        throw new IllegalArgumentException("[ERROR]");
    }


    private boolean matchCount(int countMatch){
        return this.countMatch == countMatch;
    }

    public void printMessage(int count){
        if(this != MISS){
            LottoView.msgSuccess(message,count);
        }
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
