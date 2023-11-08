package lotto.domain;

public class LottoWinner {

    private final Lotto lotto;
    private final int bonusball;



    public LottoWinner(Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;


    }

    public LottoRanking match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusball);
        return LottoRanking.valueOf(countOfMatch, bonusCheck);
    }


    public static boolean containNumber(Integer integer) {
        return false;
    }
}
