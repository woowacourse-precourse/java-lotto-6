package lotto.model;

public class LottoWinner {

    private static Lotto winningLotto;
    private static Bonus bonusLotto;

    public static void create(Lotto winning, Bonus bonus) {
        winningLotto = winning;
        bonusLotto = bonus;
    }

    public static int compareWinningLotto(Lotto lotto) {
        return winningLotto.countSameNumbers(lotto);
    }

    public static boolean compareBonusLotto(Lotto lotto) {
        return bonusLotto.countSameNumber(lotto);
    }
}
