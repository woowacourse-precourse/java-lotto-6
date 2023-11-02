package lotto;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static int insertMoney(){
        String money = Console.readLine();
        return Integer.valueOf(money);
    }
}
