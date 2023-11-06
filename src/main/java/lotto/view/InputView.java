package lotto.view;

import static lotto.enums.InputMessages.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String purchaseMoney(){
        System.out.println(PURCHASE_MONEY.getMessage());
        return Console.readLine();
    }

    public static String winningNumber(){
        System.out.println(WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String bonusNumber(){
        System.out.println(BONUS_NUMBER.getMessage());
        return Console.readLine();
    }

}
