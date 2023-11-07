package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Constant;


public class InputView {

    public String inputPurchaseAmount(){
        System.out.println(Constant.GET_PURCHASE_AMOUNT_TXT);
        return Console.readLine();
    }

    public String inputWinningNumber(){
        System.out.println();
        System.out.println(Constant.GET_WINNING_NUMBER_TXT);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println();
        System.out.println(Constant.GET_BONUS_NUMBER_TXT);
        return Console.readLine();
    }
}
