package lotto.domin;

import java.util.List;

import static lotto.domin.Exception.*;

//숫자 체크 , 1~45 , 중복 체크
public class Bonus {
    private final int bonus;

    public int getBonus() {
        return bonus;
    }

    public Bonus(String inputBonusNumber, List<Integer> selectLottoNumber) throws  IllegalArgumentException{
        BonusValidate(inputBonusNumber, selectLottoNumber);
        bonus= Integer.parseInt(inputBonusNumber);
    }

    private void BonusValidate(String inputBonusNumber, List<Integer> selectLottoNumber) throws IllegalArgumentException{
        NumberCheck(inputBonusNumber);
        int getInputBonus = Integer.parseInt(inputBonusNumber);
        overNumber(getInputBonus);
        duplicationCheckBonus(getInputBonus, selectLottoNumber);
    }
}
