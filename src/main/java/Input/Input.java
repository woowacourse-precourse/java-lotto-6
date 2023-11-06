package Input;

import Except.Except;
import Output.Output;
import lotto.BuyLotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static int money;
    private static int lotto_number;
    private static Output output = new Output();
    private static Except except = new Except();
    private static BuyLotto buylotto = new BuyLotto();

    public void lottoBuyMoney() {
        do {
            output.buyMoneyAsk();
            String money_string = readLine();
            money = except.outOfRangeMoney(money_string);
        } while (money < 0);
        lotto_number = money / 1000;
        output.buyNumberPaperAns(lotto_number);
        buylotto.buyAllLotto(lotto_number);
    }
}
