package lotto;

import domain.User;
import domain.io.Input;
import domain.io.Output;
import strategy.InjectionStrategy;
import strategy.LottoStrategy;
import strategy.RandomStrategy;

import java.util.ArrayList;

public class LottoGame {
    private Input input;
    private Output output;
    private User player;
    private User com;

    public LottoGame() {
        input = new Input();
        output = new Output();
        com = User.ComUser(new InjectionStrategy());
    }

    public int loopInput() {
        int money;
        while(true) {
            try {
                money = input.inputMoney();
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return money;
    }
    public void runGame() {

        int money = loopInput();
        player = User.playUserFrom(money, new RandomStrategy());

        for (int i = 0; i < player.getAttempt(); i++) {
            player.drawSingleLotto(new ArrayList<Integer>(), -1);
        }

        output.printBuy(player.getTickets());

        ArrayList<Integer> numberList = input.inputNumbers();
        int bonusNumber = input.inputBonus();

        com.drawSingleLotto(numberList, bonusNumber);
        player.updateResult(com.getTickets().get(0));
        Integer resultMoney = output.printResult(player.getTotalWinningResult());
        output.printRate(money, resultMoney);















    }
}
