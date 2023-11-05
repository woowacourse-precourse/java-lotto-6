package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.domain.Message.*;


public class InputView {



    public static String inputMoney(){
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }


    public static String inputWinningNum(){
        System.out.println(INPUT_WINNING_NUM);
        return Console.readLine();
    }

    public static String inputBonusNum(){
        System.out.println(INPUT_BONUS_NUM);
        return Console.readLine();
    }




}
