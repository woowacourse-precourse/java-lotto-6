package Game;

import Input.Input;
import Output.Output;
import lotto.BuyLotto;

public class Game {
    private static Input input = new Input();
    private static Output output = new Output();
    private static BuyLotto buylotto = new BuyLotto();
    private static int lotto_number;

    public void askMoney() {
        lotto_number = input.lottoBuyMoney();
        output.buyNumberPaperAns(lotto_number);
        buylotto.buyAllLotto(lotto_number);
    }
}
