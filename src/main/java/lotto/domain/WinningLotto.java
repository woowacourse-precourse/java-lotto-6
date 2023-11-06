package lotto.domain;

public class WinningLotto   {
    private static Lotto LOTTO;
    private static int BONUS;

    public WinningLotto(Lotto lotto, int bonus) {
        this.LOTTO = lotto;
        this.BONUS = bonus;
    }

    public static Rank compare(Lotto lotto) {
        int countOfMatch = countMatchNumber(lotto);
        boolean hasBonus = lotto.getNumbers().contains(BONUS);
        for (Rank rank : Rank.values()) {
            return rank.valueOf(countOfMatch, hasBonus);
        }
        return Rank.LOSING_TICKET;
    }

    private static int countMatchNumber(Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (LOTTO.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }
}
