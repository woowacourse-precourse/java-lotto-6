package lotto.service;

public enum LottoType {

    MATCH_THREE(3, "5,000"),
    MATCH_FOUR(4, "50,000"),
    MATCH_FIVE(5,"1,500,000"),
    MATCH_FIVE_BONUS(5,"30,000,000"),
    MATCH_SIX(6,"2,000,000,000"),
    NOTHING(0,"0");
    private String prize;
    private int matchCount;

    private static int THREE = 3;
    private static int FOUR = 4;
    private static int FIVE = 5;
    private static int SIX = 6;



    LottoType(int matchCount, String prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }


    public static LottoType of(int matchCount, boolean matchBonus) {
        if(matchCount == THREE) {
            return MATCH_THREE;
        }
        if(matchCount == FOUR) {
            return MATCH_FOUR;
        }
        if(matchCount == FIVE && matchBonus) {
            return MATCH_FIVE_BONUS;
        }
        if(matchCount == FIVE) {
            return MATCH_FIVE;
        }
        if(matchCount == SIX) {
            return MATCH_SIX;
        }
        return NOTHING;
    }

    public String getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
