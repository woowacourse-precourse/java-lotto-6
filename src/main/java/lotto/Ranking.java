package lotto;

public enum Ranking {
    FIRST("3개 일치 (5,000원) - ", 0),
    SECOND("4개 일치 (50,000원) - ", 0),
    THIRD("5개 일치 (1,500,000원) - ", 0),
    FOURTH("5개 일치, 보너스 볼 일치 (30,000,000원) - ",0),
    FIFTH("6개 일치 (2,000,000,000원 - ",0);

    private String ranking;
    private int number;

    Ranking(String ranking, int number){
        this.ranking = ranking;
        this.number = number;
    }

    public void setRankingNumber(int number){
        this.number = number;
    }

    public int getRankingNumber(){
        return number;
    }
    public String getRankingName(){
        return ranking;
    }
}
