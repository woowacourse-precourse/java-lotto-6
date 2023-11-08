package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Utils;
import java.util.List;
import view.InputView;

public class Controller {

    public void run() {
        
    }

    private int getPurchaseAmount() {
        System.out.println(InputView.INPUT_PURCHASE_AMOUNT);
        String userInput = Console.readLine().trim();
        return Utils.stringToInteger(userInput);
    }

    private List<Integer> getWinningNumbers() {
        System.out.println(InputView.INPUT_WINNING_NUMBERS);
        String winningNumbers = Console.readLine().trim();
        return Utils.stringToIntegerList(winningNumbers);
    }

    private int getBonusNumber() {
        System.out.println(InputView.INPUT_BONUS_NUMBERS);
        String bonusNumbers = Console.readLine().trim();
        return Utils.stringToInteger(bonusNumbers);
    }
}
