package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.configs.Constant;
import lotto.utils;

public class Machine{
    private Lotto lotto;
    private int bonus;
    public Machine(){
        this.lotto = null;
        this.bonus = 0;
    }
    public void setNumbers(List<Integer> numbers, int bonus){
        this.lotto = new Lotto(numbers);
        this.bonus = bonus;
        validate();
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

    private void validate(){
        if(lotto.hasNumber(bonus)){
            throw new IllegalArgumentException(utils.createErrorMessage(Constant.ERROR_MESSAGE_DUPLICATED_NUMBER));
        }
    }

}
