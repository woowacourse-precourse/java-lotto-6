package lotto.model;

import java.util.List;

public enum LottoRankings {

    FIRST(6, List.of(true, false), "6개 일치 (%s원) - %d개", 2000000000),
    SECOND(5, List.of(true), "5개 일치, 보너스 볼 일치 (%s원) - %d개", 30000000),
    THIRD(5, List.of(false), "5개 일치 (%s원) - %d개", 1500000),
    FOURTH(4, List.of(true, false), "4개 일치 (%s원) - %d개", 50000),
    FIFTH(3, List.of(true, false), "3개 일치 (%s원) - %d개", 5000),
    NONE(0, List.of(true, false), "", 0);

    private final int match;
    private final List<Boolean> bonus;
    private final String message;
    private final int winningAmount;

    LottoRankings(int match, List<Boolean> bonus, String message, int winningAmount) {
        this.match = match;
        this.bonus = bonus;
        this.message = message;
        this.winningAmount = winningAmount;
    }

    public int getMatch() {
        return match;
    }

    public List<Boolean> getBonus() {
        return bonus;
    }

    public String getMessage() {
        return message;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
