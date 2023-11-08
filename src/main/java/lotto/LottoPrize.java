package lotto;

public enum LottoPrize {
    
    LESS_THAN_THREE_MATCH(0,false,0,"0원"),
    THREE_MATCH(3,false,5000,"5,000원"),
    FOUR_MATCH(4,false,50000,"50,000원"),
    FIVE_MATCH(5,false,1500000,"1,500,000원"),
    FIVE_BONUS_MATCH(5,true,30000000,"30,000,000원"),
    SIX_MATCH(6,false,200000000,"2,000,000,000원");
    
    private final int MATCH_COUNT;
    private final boolean MATCH_BONUS;
    private final int PRIZE;
    private final String PRIZE_TEXT;
    
    LottoPrize(int matchCount, boolean matchBonus, int prize, String prizeText) {
        this.MATCH_COUNT = matchCount;
        this.MATCH_BONUS = matchBonus;
        this.PRIZE = prize;
        this.PRIZE_TEXT = prizeText;
    }
    
    public int getMatchCount() {
        return MATCH_COUNT;
    }
    
    public boolean doesBonusMatch() {
        return MATCH_BONUS;
    }
    
    public int getPrize() {
        return PRIZE;
    }
    
    public String getPrizeText() {
        return PRIZE_TEXT;
    }
    
    public void print(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(MATCH_COUNT);
        sb.append("개 일치");
        if (MATCH_BONUS) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (");
        sb.append(PRIZE_TEXT);
        sb.append(") - ");
        sb.append(count);
        sb.append("개");
        System.out.println(sb.toString());
    }
}
