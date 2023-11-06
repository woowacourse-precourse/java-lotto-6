package Game;

import Input.Input;
import Output.Output;
import lotto.BuyLotto;

import java.util.List;

public class Game {
    private static Input input = new Input();
    private static Output output = new Output();
    private static BuyLotto buylotto = new BuyLotto();
    private static int lotto_number;
    private static List<Integer> answer_number;
    private static int bonus_number;

    public void askMoney() {
        lotto_number = input.lottoBuyMoney();
        output.buyNumberPaperAns(lotto_number);
        buylotto.buyAllLotto(lotto_number);
        lotto_number *= 1000;
    }

    public void askNumber() {
        answer_number = input.answerNumber();
        bonus_number = input.bonusNumber();
    }
}
