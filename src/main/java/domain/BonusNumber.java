package domain;

import validator.BonusNumberValidator;

public class BonusNumber {

    public BonusNumber(int num){
        BonusNumberValidator.validRange(num);
    }

    public BonusNumber(String inputData){
        int number = BonusNumberValidator.validNumberic(inputData);
        BonusNumberValidator.validRange(number);
    }
}
