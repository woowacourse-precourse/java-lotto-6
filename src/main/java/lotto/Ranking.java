package lotto;

public enum Ranking {

    First(6,2_000_000_000,"6개 일치 (2,000,000,000원)-"),
    Second(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    Third(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    Fourth(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    Fifth(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    Miss(0, 0, "");

    private final int CountOfMatch;
    private final int winningAmount;
    private final String message;


    Ranking(int CountOfMatch, int winningAmount, String message){
        this.CountOfMatch=CountOfMatch;
        this.winningAmount=winningAmount;
        this.message=message;
    }
    public static Ranking valueOf(int CountofMatch,boolean matchBonus){
        if(CountofMatch<3){
            return Miss;
        }
        if(Second.matchCount(CountofMatch)&&matchBonus){
            return Second;
        }
        for(Ranking rank : values()){
            if(rank.matchCount(CountofMatch)&&rank!=Second){
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public int getCountOfMatch(){
        return CountOfMatch;
    }
    public int getWinningAmount(){
        return winningAmount;
    }
    public boolean matchCount(int CountOfMatch){
        return this.CountOfMatch==CountOfMatch;
    }
    public void printMessage(int count){
        if(this != Miss){
            System.out.println(message+count+"개");
        }
    }


}
