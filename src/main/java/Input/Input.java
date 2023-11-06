package Input;

import Output.Output;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public void lottoBuyMoney(){
        Output output = new Output();
        output.buyMoneyAsk();
        String money_string = readLine();
        int money = outOfRangeMoney(money);
    }
}
