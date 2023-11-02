package controller;

import camp.nextstep.edu.missionutils.Console;
import validation.ValidationMan;

class InputMan {
    private ValidationMan validationMan = new ValidationMan();
    private final static int EXCEPTION_NUMBER = -1;
    int receiveMoney() {
        String money = Console.readLine();
        if(!validationMan.validateMoney(money))
        {
            return -1;
        }
        return Integer.parseInt(money);
    }

}
