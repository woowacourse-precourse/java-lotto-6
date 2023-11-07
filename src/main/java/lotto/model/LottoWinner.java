package lotto.model;

public class LottoWinner {

    private static Lotto winningLotto;
    private static Bonus bonusLotto;

    public static void create(Lotto winning, Bonus bonus) {
        winningLotto = winning;
        bonusLotto = bonus;
    }
}
