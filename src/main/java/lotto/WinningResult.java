package lotto;

public class WinningResult{

    private final Lotto lotto;
    private final int bonus;

    public WinningResult(Lotto lotto,int bonus) {
        this.lotto = lotto;
        this.bonus=bonus;
    }

    public Ranking match(Lotto player){
        int countOfMatch = player.CorrectLottoCount(lotto);
        boolean bonuscheck = player.containNumber(bonus);
        return Ranking.valueOf(countOfMatch,bonuscheck);
    }


}
