package lotto.domain;

public class LottoResult {
    private final int matches;
    private final boolean bonus;

    public LottoResult(int matches, boolean bonus) {
        this.matches = matches;
        this.bonus = bonus;
    }

    public int getMatches() {
        return matches;
    }

    public boolean isBonus() {
        return bonus;
    }

    public LottoPrize getPrize() {
        return LottoPrize.findByMatchesAndBonus(matches, bonus);
    }
}
