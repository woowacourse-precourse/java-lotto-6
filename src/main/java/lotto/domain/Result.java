package lotto.domain;

public class Result {
    private Lotto lotto;
    private int bonusNum;

    public Result(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    public Ranking match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusNum);
        return Ranking.valueOf(countOfMatch, bonusCheck);
    }

}
