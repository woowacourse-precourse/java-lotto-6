package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(){
        inputValidator = new InputValidator();
    }

    public void InputMoney(){
        String input = Console.readLine();
        try{
            inputValidator.isNumericValidator(input);
            Integer money = Integer.parseInt(input);
            inputValidator.isMinimumValidator(money);
            inputValidator.isThousandUnitValidator(money);
            // 여기에 static 변수 사용하면 될듯
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void InputSixNumbers(){}
    public void InputBonusNumber(){}
}
