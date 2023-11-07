package lotto.model;

public class LottoWinner {

    private static Lotto winningLotto;
    private static Bonus bonusLotto;

    public static void create(Lotto winning, Bonus bonus) {
        winningLotto = winning;
        bonusLotto = bonus;
    }

    public static void compareWithLotto(Lotto lotto) {
        int correctCount = winningLotto.compareLottoWith(lotto);
    }
}
