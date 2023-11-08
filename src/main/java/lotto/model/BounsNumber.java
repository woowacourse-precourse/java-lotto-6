package lotto.model;

import lotto.validate.InvalidlputException;

public class BounsNumber {

    private final int bonusNumber;

    public BounsNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public int createBonusNumber(String inputNumber){
        return Integer.parseInt(inputNumber);
    }


}
