package lotto;

import lotto.Exceptions.ManageExceptions;
import lotto.view.Input;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        ManageExceptions manageExceptions = new ManageExceptions();

        int cash = input.getCash();
        List<Integer> winningNums = input.getWinningNums();
        int BonusNum =input.getBonusNum(winningNums);
    }
}
