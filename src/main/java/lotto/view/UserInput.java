package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static String ConsoleInputBoughtMoney(){
        UserOutput.ConsolePrintBoughtInfo();
        return Console.readLine();
    }

    public static String ConsoleInputWinningNumber(){
        UserOutput.ConsolePrintWinningInfo();
        return Console.readLine();
    }

    public static String ConsoleInputBonusNumber(){
        UserOutput.ConsolePrintBonusInfo();
        return Console.readLine();
    }
}
