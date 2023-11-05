package lotto.strings;

public enum Prize {
    OUT(0,0,""),
    FIFTH(3,5000,"3개 일치 (5,000원)"),
    FOURTH(4,50000,"4개 일치 (50,000원)"),
    THIRD(5,1500000,"5개 일치 (1,500,000원)"),
    SECOND(5,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6,2000000000,"6개 일치 (2,000,000,000원)")
    ;
    public static final Integer minCount = 3;
    private final Integer matchCount;
    private final Integer reward;
    private final String message;
    Prize(Integer matchCount,Integer reward, String message) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.message = message;
    }


    public Prize calculate(Integer match,boolean bonus){
        if(SECOND.matchCount.equals(match) && bonus){
            return SECOND;
        }
        for(Prize prize: values()){
            if(prize.matchCount.equals(match)&&prize!=SECOND){
                return prize;
            }
        }
        return OUT;
    }
    public Integer getMatchCount(){
        return matchCount;
    }
    public Integer getReward(){
        return reward;
    }
    public String printMessage(Integer matchCount){
        if(this!=OUT){
            return this.message;
        }
        return "";
    }
}
