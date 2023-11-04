package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {

    public Integer InputMoney(){
        String input = Console.readLine();
        try{
            InputValidator.isNumericValidator(input);
            Integer money = Integer.parseInt(input);
            InputValidator.isMinimumValidator(money);
            InputValidator.isThousandUnitValidator(money);
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void InputSixNumbers(){
        String input = Console.readLine();
        try{

        }
    }
    public void InputBonusNumber(){}
}
