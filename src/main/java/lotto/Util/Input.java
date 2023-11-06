package lotto.Util;

import static lotto.Constant.Const.*;
import camp.nextstep.edu.missionutils.Console;
public class Input {
    public static String userInputPurchaseLotto(){
        System.out.println(PLZ_INPUT_PURCHASE_LOTTO_PRICE);
        return Console.readLine();
    }

    public static String userInputWinningNumber(){
        System.out.println("\n" + PLZ_INPUT_WINNING_LOTTO_NUMBER);
        return Console.readLine();
    }

    public static String userInputBonusNumber(){
        System.out.println("\n" + PLZ_INPUT_BONUS_LOTTO_NUMBER);
        return Console.readLine();
    }

}
