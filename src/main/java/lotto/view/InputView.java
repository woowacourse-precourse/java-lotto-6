package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {

    public static String inputPurchaseAmount(){
        return Validator.checkNullValue(Console.readLine());
    }
}
