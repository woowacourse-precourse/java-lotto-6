package lotto.model;

public class ComputePrize {

    private static int bonus;
    private static Lotto lotto;

    public ComputePrize(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Prize match(Lotto lottoNum){
        int countOfMatch = lotto.countMatch(lottoNum);
        boolean bonusCheck = false;
        if(countOfMatch == 5){
            bonusCheck = lottoNum.checkBonus(bonus);
        }
        return Prize.valueOf(countOfMatch,bonusCheck);
    }
}
