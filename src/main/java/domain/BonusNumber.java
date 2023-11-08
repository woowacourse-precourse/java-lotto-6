package domain;

import validator.BonusNumberValidator;

public class BonusNumber {

    private final int number;

    public int getNumber() {
        return number;
    }

    public BonusNumber(int number){
        BonusNumberValidator.validRange(number);
        this.number = number;
    }

    public BonusNumber(String inputData){
        this.number = BonusNumberValidator.validNumberic(inputData);
        BonusNumberValidator.validRange(number);
    }
}
