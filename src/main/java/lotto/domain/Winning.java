package lotto.domain;

public class Winning {
    private final Lotto lotto;
    private final int bonus;

    public Winning(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Ranking match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countContain(lotto);
        boolean bonusCheck = playerNumber.containCheck(bonus);
        return Ranking.calculator(countOfMatch, bonusCheck);
    }

}
