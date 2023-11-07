package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Comments;


public  class InputView {
    public static String inputPurcasePrice(){
        System.out.println(Comments.INPUT_PURCHASE_PRICE);
        return Console.readLine();
    }

    public static String inputWinningNumber(){
        System.out.println();
        System.out.println(Comments.INPUT_WINNING_LOTTO_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber(){
        System.out.println();
        System.out.println(Comments.INPUT_WINNING_BONUS_LOTTO_NUMBER);
        return Console.readLine();
    }
}
