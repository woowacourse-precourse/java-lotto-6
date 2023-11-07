package lotto.Lottery.Enum;

import java.util.HashMap;
import java.util.Map;

public enum LottoWinnings {
    FIRST_GRADE(2000000000, 6,0),
    SECOND_GRADE(30000000, 7, 1),
    THIRD_GRADE(1500000, 5, 2),
    FIRTH_GRADE(50000, 4, 3),
    FIFTH_GRADE(5000, 3, 4),
    NO_GRADE1(0,2,5),
    NO_GRADE2(0, 1, 5),
    NO_GRADE3(0,0,5);

    public int getWinnings() {
        return winnings;
    }

    public int getMatch() {
        return match;
    }

    public int getOrder() {
        return order;
    }

    private final int winnings;
    private final int match;
    private final int order;

    private LottoWinnings(int winnings, int match, int order){
        this.winnings = winnings;
        this.match = match;
        this.order = order;
    }

    private static final Map<Integer, LottoWinnings> BY_MATCH = new HashMap<>();

    static{
        for(LottoWinnings w : values()){
            BY_MATCH.put(w.match, w);
        }
    }

    public static LottoWinnings valueOfMATCH(int match){
        return BY_MATCH.get(match);
    }
}
