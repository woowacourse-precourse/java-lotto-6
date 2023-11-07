package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public int inputMoney() {
        int tryNum;
        int money;

        String moneyString = Console.readLine();

        money = Integer.parseInt(moneyString);

        tryNum = money/1000;
        
        return tryNum;
    }

 
}
