package lotto;


public class Check {
    private final Lotto lotto;
    private final int bonusball;

    public Check(Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;
    }

    public Result match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusball);
        return Result.valueOf(countOfMatch, bonusCheck);
    }
}
