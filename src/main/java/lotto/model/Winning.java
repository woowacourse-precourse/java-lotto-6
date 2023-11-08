package lotto.model;

public class Winning {
    Lotto lotto;
    int bonus;

    public Winning(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Result match(Lotto temp) {
        int count = temp.countMatch(lotto);
        boolean bonusCheck = temp.containNumber(bonus);
        return Result.valueOf(count, bonusCheck);
    }
}
