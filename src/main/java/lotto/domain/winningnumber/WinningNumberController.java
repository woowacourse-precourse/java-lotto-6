package lotto.domain.winningnumber;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.result.ResultController;
import lotto.view.View;

public class WinningNumberController {
    public WinningNumber winningNumber;
    public ResultController resultController;
    public View view;

    public WinningNumberController() {
        view = new View();
        view.askWinningNumbers();
        String numbers = Console.readLine();
        view.breakLine();

        view.askBonusNumber();
        String bonusNumber = Console.readLine();
        view.breakLine();

        winningNumber = new WinningNumber(numbers, bonusNumber);
        resultController = new ResultController(winningNumber);
    }
}
