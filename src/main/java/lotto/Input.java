package lotto;

import camp.nextstep.edu.missionutils.Console;
public class Input {
    public static String getPurchaseAmount(){
        System.out.println(Output.LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String getWinningNumbers(){
        System.out.println(Output.LOTTO_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String getBonusNumber(){
        System.out.println(Output.LOTTO_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
