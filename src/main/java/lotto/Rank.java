package lotto;

import java.util.List;

public enum Rank {
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String message;

    Rank(int matchCount,boolean matchBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.message = message;
    }

    public static Rank checkLotto(Lotto lotto, List<Integer> winningNumber, int bonusNumber){
        return null;
    }




}
