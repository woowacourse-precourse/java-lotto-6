package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class LottoController {
    public static void inputPurchaseAmount(){
        String amount = Console.readLine();
        Validator.validateInputAmount(amount);
    }
    


}
