package lotto.domain.winningnumber;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.result.ResultController;
import lotto.view.View;

public class WinningNumberController {
    public WinningNumber winningNumber;
    public ResultController resultController;
    public View view;

    public WinningNumberController() {
        String numbers;
        String bonusNumber;

        view = new View();
        view.askWinningNumbers();
        while (true) {
            try {
                numbers = Console.readLine();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        view.breakLine();

        view.askBonusNumber();
        while (true) {
            try {
                bonusNumber = Console.readLine();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        view.breakLine();

        winningNumber = new WinningNumber(numbers, bonusNumber);
        resultController = new ResultController(winningNumber);
    }
}
