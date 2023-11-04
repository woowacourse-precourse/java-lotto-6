package lotto.model;

import java.util.List;
import java.util.stream.Stream;

public enum Ranking {
    THREE(3, 5_000, List.of(true, false), "%d개 일치 (%s원) - %d개\n"),
    FOUR(4, 50_000, List.of(true, false), "%d개 일치 (%s원) - %d개\n"),
    FIVE(5, 1_500_000, List.of(false), "%d개 일치 (%s원) - %d개\n"),
    BONUS(5, 30_000_000, List.of(true), "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    SIX(6, 2_000_000_000, List.of(true, false), "%d개 일치 (%s원) - %d개\n");

    private final int amount;
    private final int machedCount;
    private final List<Boolean> hasBonus;
    private final String message;

    Ranking(int machedCount, int amount, List<Boolean> hasBonus, String message) {
        this.machedCount = machedCount;
        this.amount = amount;
        this.hasBonus = hasBonus;
        this.message = message;
    }

    public static List<Ranking> getAllRankingCase() {
        return Stream.of(Ranking.values()).toList();
    }

    public int getAmount() {
        return amount;
    }

    public int getMachedCount() {
        return machedCount;
    }

    public List<Boolean> getHasBonus() {
        return hasBonus;
    }

    public String getMessage() {
        return message;
    }

}
