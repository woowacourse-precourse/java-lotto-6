package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.constant.Rank;
import lotto.ui.Input;
import lotto.ui.Output;

public class Game {
    private final LottoMachine lottoMachine = new LottoMachine();
    private int amount;

    private List<Lotto> createLotteries() {
        while (true) {
            Output.printMessage(Input.AMOUNT);
            try {
                amount = Input.readAmount(Console.readLine());
                return lottoMachine.issue(amount / LottoNumber.PRICE.getValue());
            } catch (IllegalArgumentException exception) {
                Output.printMessage(exception.getMessage());
            }
        }
    }

    private Lotto createWinningNumber() {
        while (true) {
            Output.printMessage(Input.WINNING_NUMBER);
            try {
                List<Integer> numbers = Input.readWinningNumber(Console.readLine());
                return new Lotto(numbers);
            } catch (IllegalArgumentException exception) {
                Output.printMessage(exception.getMessage());
            }
        }
    }

    private int createBonus(List<Integer> winningNumber) {
        while (true) {
            Output.printMessage(Input.BONUS);
            try {
                return Input.readBonus(Console.readLine(), winningNumber);
            } catch (IllegalArgumentException exception) {
                Output.printMessage(exception.getMessage());
            }
        }
    }


    public void start() {
        List<Lotto> lotteries = createLotteries();
        Output.printLotto(lotteries);
        Lotto winningNumber = createWinningNumber();
        int bonus = createBonus(winningNumber.getNumbers());

        List<Rank> result = lottoMachine.draw(winningNumber, bonus, lotteries);
        Output.printResult(result);
        double winnings = lottoMachine.combineWinnings(result);
        System.out.printf("%.2f%n", winnings / amount * 100);
    }
}
