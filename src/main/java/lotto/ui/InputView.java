package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import static lotto.ui.GuideMessageConst.INPUT_AMOUNT_MESSAGE;
import static lotto.util.Validator.validateAmount;

public class InputView {

    public static int inputAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        String amountStr ="";
        while(true){
            amountStr = Console.readLine();
            try {
                validateAmount(amountStr);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return Integer.parseInt(amountStr);
    }


}
