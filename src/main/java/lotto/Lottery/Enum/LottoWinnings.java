package lotto.Lottery.Enum;

import java.util.HashMap;
import java.util.Map;

public enum LottoWinnings {
    FIRST_GRADE(2000000000),
    SECOND_GRADE(30000000),
    THIRD_GRADE(1500000),
    FIRTH_GRADE(50000),
    FIFTH_GRADE(5000);

    private final int winnings;

    private LottoWinnings(int winnings){
        this.winnings = winnings;
    }

    private static final Map<Integer, LottoWinnings> BY_WINNINGS = new HashMap<>();

    static{
        for(LottoWinnings w : values()){
            BY_WINNINGS.put(w.winnings, w);
        }
    }

    public static LottoWinnings valueOfWinnings(int winnings){
        return BY_WINNINGS.get(winnings);
    }
}
