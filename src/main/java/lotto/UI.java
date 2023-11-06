package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import static lotto.Constant.*;
import static lotto.Validation.*;

public class UI {
    public static int getMoney() {
        System.out.print(GET_MONEY_MSG);
        String input = Console.readLine();
        return validateMoney(input);
    }

    public static void printLottos(int amount, List<Lotto> lottos){

    }

    public static List<Integer> getWinningNumber(){
        return null;
    }

    public static int getBonusNumber(){
        return 0;
    }

}
