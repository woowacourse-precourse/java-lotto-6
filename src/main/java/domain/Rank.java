package domain;

public enum Rank {
    LOSING_TICKET(0,0,""),
    FIFTH_PLACE(3,5000,"3개 일치 (5,000원) - "),
    FOURTH_PLACE(4,50000,"4개 일치 (50,000원) - "),
    THIRD_PLACE(5,1500000,"5개 일치 (1,500,000원) - "),
    SECOND_PLACE(5,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE(6,2000000000,"6개 일치 (2,000,000,000원) - ");

    private int numberOfMatch;
    private int prizeMoney;
    private String message;
    private Rank(int numberOfMatch, int prizeMoney, String message) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getNumberOfMatch() {return this.numberOfMatch;}
    public int getPrizeMoney() {return this.prizeMoney;}
    public String getMessage() {return this.message;}

    public static Rank checkTicketRank(int numberOfMatch , boolean isMatchBonusNumber){
        if(SECOND_PLACE.isSameNumberOfMatch(numberOfMatch) && isMatchBonusNumber){
            return SECOND_PLACE;
        }
        for(Rank rank : Rank.values()){
            if(rank.isSameNumberOfMatch(numberOfMatch) && !isMatchBonusNumber){
                return rank;
            }
        }
        return LOSING_TICKET;
    }
    public boolean isSameNumberOfMatch(int numberOfMatch){
        return this.numberOfMatch == numberOfMatch;
    }


}
