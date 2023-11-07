package lotto.dto;

public class MatchCountDto {
    private final int match;
    private final int bonus;

    public MatchCountDto(int match, int bonus) {
        this.match = match;
        this.bonus = bonus;
    }

    public int getMatch() {
        return match;
    }

    public int getBonus() {
        return bonus;
    }
}