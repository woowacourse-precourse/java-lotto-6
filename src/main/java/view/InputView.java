package view;

import camp.nextstep.edu.missionutils.Console;

import static util.message.InputMessage.GET_PURCHSE_AMOUNT;

public class InputView {
    public static String inputPurchaseAmount(){
        System.out.println(GET_PURCHSE_AMOUNT.getValue());
        return Console.readLine();
    }
}
