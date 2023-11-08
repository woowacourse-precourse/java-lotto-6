package message;

public enum OuputMessage {
    PAYRESULT("개를 구매했습니다."),
    HEADRESULT("당첨 통계\n---"),
    TOTALRATE("총 수익률은 "),
    PERCENT("%입니다."),
    MATCHTHREE(3),
    MATCHFOUR(4),
    MATCHFIVE(5),
    MATCHSIX(6);
    private String message;
    private Integer matchCount;
    OuputMessage(String message){
        this.message = message;
    }
    OuputMessage(Integer matchCount){
        this.matchCount = matchCount;
    }
    public String getMessage(){
        return message;
    }
    public Integer getMatchCount(){
        return matchCount;
    }

}
