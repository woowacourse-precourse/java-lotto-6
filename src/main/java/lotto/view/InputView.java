package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputValidate;

public class InputView {

    public static int getLottoNumber(){
        String number = Console.readLine();
        try{
            InputValidate.validateIsNumber(number);
            InputValidate.validateIsDivideThousand(number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLottoNumber();
        }
        return Integer.parseInt(number)/1000;
    }
}
