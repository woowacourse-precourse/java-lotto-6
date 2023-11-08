package lotto.domain;

public class LottoWinner {

    private final Lotto lotto;
    private final int bonusball;

    public LottoWinner(Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;
    }

    public LottoRanking match(Lotto playerNumbers ) {
        int countOfMatch = playerNumbers.countMatch(lotto);
        boolean bonusCheck = playerNumbers.containNumber(bonusball);
        return LottoRanking.valueOf(countOfMatch, bonusCheck);
    }



}
