package lotto.entity;

public enum Prize {
    //    OUT(0,0,0,""),
//    FIFTH(3,5,5000,"3개 일치 (5,000원)"),
//    FOURTH(4,4,50000,"4개 일치 (50,000원)"),
//    THIRD(5,3,1500000,"5개 일치 (1,500,000원)"),
//    SECOND(5,2,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
//    FIRST(6,1,2000000000,"6개 일치 (2,000,000,000원)")
//    ;
    OUT(0, false, 0,""),
    FIFTH(3, false, 5000,"3개 일치 (5,000원)"),
    FOURTH(4, false, 50000,"4개 일치 (50,000원)"),
    THIRD(5, false, 1500000,"5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000,"6개 일치 (2,000,000,000원)");
    private final Integer matchCount;
    private final boolean bonusMatch;
    private final Integer reward;
    private final String message;

    Prize(Integer matchCount, boolean bonusMatch, Integer reward,String message) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.reward = reward;
        this.message = message;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public Integer getReward() {
        return reward;
    }
    public String getMessage(){
        return message;
    }
}
