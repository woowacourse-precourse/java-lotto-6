package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.MoneyValidation;
public class Input {

    public String readMoney(){
        String input = Console.readLine();
        checkNumberValidator(input);
        return input;
    }

    public String inputWinNumber(){
        String input = Console.readLine();
        //에러 확인 부분
        return input;
    }


    private void checkNumberValidator(String input){
        MoneyValidation moneyValidation = new MoneyValidation();
        moneyValidation.validate(input);
    }

}
