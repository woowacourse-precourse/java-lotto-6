package lotto;

public class Match {
    private Integer reward = 0;
    private String matchId = "";
    private Integer matchLottoCount = 0;

    private String printString = "";
    public Match(int reward, String matchId, String printString){
        this.reward = reward;
        this.matchId = matchId;
        this.printString = printString;
    }

    public int getReward() {
        return this.reward;
    }

    public String getPrintString() {
        return printString;
    }

    public Integer getMatchLottoCount() {
        return this.matchLottoCount;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public void increaseMatchLottoCount(){
        this.matchLottoCount++;
    }
}
