package Game;

import Input.Input;
import Money.Money;
import Output.Output;
import lotto.BuyLotto;

import java.util.List;

public class Game {
    private static Input input = new Input();
    private static Output output = new Output();
    private static BuyLotto buylotto = new BuyLotto();
    private static Money calculate = new Money();
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
        bonus_number = input.bonusNumber(answer_number);
    }

    public void correctNumber() {
        List<Integer> rank = buylotto.lottoRank(answer_number, bonus_number);
        output.StatisPrint(rank);
        long total_money = output.totalMoney(rank);
        calculate.calculateRevenue(lotto_number, total_money);
    }
}
