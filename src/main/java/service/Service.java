package service;

import validator.Validator;

public class Service {
    Validator validator = new Validator();
    public int getAmountByUserInput(String input){
        validator.checkIsNumber(input);
        int amount = Integer.parseInt(input);
        //validator.checkDividedByThousand(amount);
        return amount;
    }
}
