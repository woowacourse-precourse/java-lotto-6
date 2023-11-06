package Input;

import Except.Except;
import Output.Output;
import lotto.BuyLotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static int money;
    private static List<Integer> answer = new ArrayList<>();
    private static int bonus = -1;
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

    public List<Integer> answerNumber() {
        List<Integer> result;
        do {
            output.answerNumberAsk();
            String number_string = readLine();
            result = except.numberCheckAll(number_string);
        } while (result.size() != 6);
        return result;
    }
}
