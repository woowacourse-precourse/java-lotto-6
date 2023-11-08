package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.configs.Constant;
import lotto.configs.Prize;

public class Machine{
    private Lotto lotto;
    private int bonus;
    public Machine(){
        this.lotto = null;
        this.bonus = 0;
    }
    public void setNumbers(Lotto lotto){
        this.lotto = lotto;
    }
    public Lotto newLottery(){
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                    Constant.LOTTO_MIN_NUMBER,
                    Constant.LOTTO_MAX_NUMBER,
                    Constant.LOTTO_COUNT
                )
        );
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Prize payPrize(Lotto lotto){
        return Prize.valueOf(lotto.getComparisonScore(this.lotto, this.bonus));
    }
}
