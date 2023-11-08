package lotto.model;

import lotto.validator.InputValidator;

import java.util.List;

import static lotto.model.Constants.MAX_LOTTO_NUMBER;
import static lotto.model.Constants.MIN_LOTTO_NUMBER;

public class Bonus {
    private final Integer bonus;

    public Bonus(String bonus) {
        InputValidator.checkUserInputIsNull(bonus);
        InputValidator.checkUserInputIsInteger(bonus);
        int tmpBonus = Integer.parseInt(bonus);
        InputValidator.checkUserInputOutOfRange(tmpBonus,MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER);
        this.bonus = tmpBonus;
    }
    public int getBonus(){ return bonus; }
    public boolean checkMatchEachLotto(List<Integer> eachLotto) {
        return eachLotto.contains(bonus);
    }

}
