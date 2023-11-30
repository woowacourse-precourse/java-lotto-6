package domain;

import util.constants.Constants;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private int countOfMatch;
    private int prize;
    private String message;

    Rank(int countOfMatch, int prize, String message){
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.message = message;
    }

    public int getCountOfMatch(){
        return countOfMatch;
    }

    public int getPrize(){
        return prize;
    }

    public String getMessage(){
        return message;
    }

    public static Rank calculateRank(int countOfMatchNumbers, boolean isMatchBonus){
        for(Rank rank : values()){
            if(rank.matches(countOfMatchNumbers, isMatchBonus)){
                return rank;
            }
        }
        return null;
    }

    private boolean matches(int countOfMatchNumbers, boolean isMatchBonus){
        if(this == SECOND){
            return checkSecond(countOfMatchNumbers, isMatchBonus);
        }
        return checkRemaining(countOfMatchNumbers, isMatchBonus);
    }

    private boolean checkSecond(int countOfMatchNumbers, boolean isMatchBonus){
        return this.countOfMatch == countOfMatchNumbers && isMatchBonus;
    }

    private boolean checkRemaining(int countOfMatchNumbers, boolean isMatchBonus){
        return this.countOfMatch == countOfMatchNumbers && !isMatchBonus;
    }


}
