package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private int bonus;

    public WinningLotto(String winningLottoStr, String winningBonusStr) {
        this.lotto = convertWinningLotto(winningLottoStr);
        this.bonus = convertWinningBonus(winningBonusStr);
    }

    public Lotto getLotto() {
        return lotto;
    }
    public Integer getBonus(){
        return bonus;
    }

    public Lotto convertWinningLotto(String lottoStr) {
        List<Integer> lotto = new ArrayList<Integer>();

        String[] splitStr = lottoStr.split(",");

        Arrays.stream(splitStr).forEach(
                l -> lotto.add(Integer.parseInt(l))
        );
        return new Lotto(lotto);
    }

    public Integer convertWinningBonus(String bonus) {
        return Integer.parseInt(bonus);
    }


    public RankingLotto matchLotto(Lotto myLotto){
        int matchCount = myLotto.countMatch(this.getLotto());
        boolean bonus = myLotto.containMatch(this.getBonus());

        return RankingLotto.matchRank(matchCount, bonus);
    }




}
