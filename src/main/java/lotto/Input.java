package lotto;

import camp.nextstep.edu.missionutils.Console;
public class Input {
    public static String getPurchaseAmount(){
        System.out.println(Output.LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
