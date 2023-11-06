package Input;

import Except.Except;
import Output.Output;
import lotto.BuyLotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static int money;
    private static Output output = new Output();
    private static Except except = new Except();


    public int lottoBuyMoney() {
        do {
            output.buyMoneyAsk();
            String money_string = readLine();
            money = except.outOfRangeMoney(money_string);
        } while (money < 0);
        return money / 1000;
    }
}
