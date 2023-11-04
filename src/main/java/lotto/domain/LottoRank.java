package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIFTH(3, List.of(true, false), 5_000, "3개 일치 (5,000원) - %d개%n"),
    FOURTH(4, List.of(true, false), 50_000, "4개 일치 (50,000원) - %d개%n"),
    THIRD(5, List.of(false), 1_500_000, "5개 일치 (1,500,000원) - %d개%n"),
    SECOND(5, List.of(true), 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    FIRST(6, List.of(true, false), 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    MISS(0, List.of(true, false), 0, ""),
    ;

    private final int match;
    private final List<Boolean> hasBonus;
    private final int winningPrize;
    private final String message;

    LottoRank(int match, List<Boolean> hasBonus, int winningPrize, String message) {
        this.match = match;
        this.hasBonus = hasBonus;
        this.winningPrize = winningPrize;
        this.message = message;
    }

    public static LottoRank getRank(int numberOfMatch, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.match == numberOfMatch)
                .filter(lottoRank -> lottoRank.hasBonus.contains(hasBonus))
                .findAny()
                .orElse(MISS);
    }

    public int getMatch() {
        return match;
    }

    public List<Boolean> getHasBonus() {
        return hasBonus;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public String getMessage() {
        return message;
    }
}
