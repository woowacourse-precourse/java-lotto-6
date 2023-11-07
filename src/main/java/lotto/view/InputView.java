package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputValidate;

public class InputView {

    final private static String START_MESSAGE = "구입금액을 입력해 주세요.";

    public static int getLottoNumber(){
        System.out.println(START_MESSAGE);
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
